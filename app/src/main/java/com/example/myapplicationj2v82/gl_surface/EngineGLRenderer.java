package com.example.myapplicationj2v82.gl_surface;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;


import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Function;
import com.example.myapplicationj2v82.html5_objects.Console;
import com.example.myapplicationj2v82.html5_objects.WebGLRenderingContext;
import com.example.myapplicationj2v82.misc.Bindings;
import com.example.myapplicationj2v82.misc.FPSCounter;
import com.example.myapplicationj2v82.misc.Files;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class EngineGLRenderer implements GLSurfaceView.Renderer {

    private V8Function renderCallBack;
    private V8 runtime;
    private Context context;
    private GLSurfaceView glSurfaceView;

    private FPSCounter fpsCounter = new FPSCounter();

    public EngineGLRenderer(android.content.Context context, GLSurfaceView glSurfaceView) {
        this.context = context;
        this.glSurfaceView = glSurfaceView;
    }

    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        GLES20.glClearColor(0,1,1,1);

        V8 runtime = V8.createV8Runtime();
        Bindings.bindObjectToV8(runtime,new Console(),"console");
        Bindings.bindObjectToV8(runtime,new WebGLRenderingContext(runtime),"_globalGL");
        runtime.executeVoidScript(Files.loadAssetFile(context,"primer.js"));
        runtime.executeVoidScript(Files.loadAssetFile(context,"test.js"));
        renderCallBack = (V8Function)runtime.executeObjectScript("_requestAnimationFrameGlobalCallBack");
        this.runtime = runtime;

    }

    public void onDrawFrame(GL10 unused) {
        long begin = System.currentTimeMillis();
        //Log.d("APP","begin "+begin);
        if (renderCallBack!=null) renderCallBack.call(runtime,null);
        long end = System.currentTimeMillis();
        //Log.d("APP","end "+end);
        //Log.d("APP","passed " + (end - begin));
        fpsCounter.logFrame();
        glSurfaceView.requestRender();

    }

    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }
}