package com.example.v_engine.gl_surface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.DisplayMetrics;
import android.util.Log;


import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Function;
import com.example.v_engine.html5_objects.Console;
import com.example.v_engine.html5_objects.WebGLRenderingContext;
import com.example.v_engine.misc.Bindings;
import com.example.v_engine.misc.FPSCounter;
import com.example.v_engine.misc.Files;
import com.example.v_engine.misc.GLObjects;
import com.example.v_engine.touch.TouchDispatcher;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class EngineGLRenderer implements GLSurfaceView.Renderer {

    private V8Function renderCallBack;
    private V8 runtime;
    private Context context;
    private GLSurfaceView glSurfaceView;
    private TouchDispatcher touchDispatcher;

    private FPSCounter fpsCounter = new FPSCounter();

    public EngineGLRenderer(android.content.Context context, GLSurfaceView glSurfaceView) {
        this.context = context;
        this.glSurfaceView = glSurfaceView;

    }

    @SuppressLint("DefaultLocale")
    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        GLES20.glClearColor(0,1,1,1);

        DisplayMetrics metrics = this.context.getResources().getDisplayMetrics();
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;

        Log.d("APP",widthPixels+":widthPixels");
        Log.d("APP",heightPixels+":heightPixels");

        V8 runtime = V8.createV8Runtime();
        GLObjects glObjects = new GLObjects(runtime);
        Files files = new Files(this.context,runtime,glObjects);
        touchDispatcher = new TouchDispatcher(runtime);
        runtime.executeVoidScript(String.format("innerWidth = %d;innerHeight = %d;",widthPixels,heightPixels));
        Bindings.bindObjectToV8(runtime,new Console(),"console");
        Bindings.bindObjectToV8(runtime,new WebGLRenderingContext(runtime,glObjects,files),"_globalGL");
        Bindings.bindObjectToV8(runtime,files,"_files");
        runtime.executeVoidScript(files.loadAssetAsString("primer.js"));
        runtime.executeVoidScript(files.loadAssetAsString("out/dragAndDrop.js"));
        renderCallBack = (V8Function)runtime.executeObjectScript("_requestAnimationFrameGlobalCallBack");
        this.runtime = runtime;

    }

    public void onDrawFrame(GL10 unused) {
        long begin = System.currentTimeMillis();
        //Log.d("APP","begin "+begin);
        if (renderCallBack!=null) renderCallBack.call(runtime,null);
        touchDispatcher.nextTick();
        long end = System.currentTimeMillis();
        //Log.d("APP","end "+end);
        //Log.d("APP","passed " + (end - begin));
        fpsCounter.logFrame();
        glSurfaceView.requestRender();

    }

    @SuppressLint("DefaultLocale")
    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        runtime.executeVoidScript(String.format("innerWidth = %d;innerHeight = %d;",width,height));
        runtime.executeVoidScript("_triggerEvent('resize')");
    }

    public void dispatchEvent(float x,float y, int touchId, String eventName){
        if (touchDispatcher!=null) touchDispatcher.dispatch(x,y,touchId,eventName);
    }


}