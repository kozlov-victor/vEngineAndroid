package com.v_engine.gl_surface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.DisplayMetrics;
import android.util.Log;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Function;
import com.v_engine.activities.MainActivity;
import com.v_engine.audio.AudioFactory;
import com.v_engine.html5_objects.Console;
import com.v_engine.html5_objects.WebGLRenderingContext;
import com.v_engine.misc.Bindings;
import com.v_engine.misc.FPSCounter;
import com.v_engine.misc.Files;
import com.v_engine.misc.GLObjects;
import com.v_engine.misc.event_queue.EventQueue;
import com.v_engine.touch.TouchDispatcher;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class EngineGLRenderer implements GLSurfaceView.Renderer {

    private V8Function renderCallBack;
    private V8 runtime;
    private Context context;
    private GLSurfaceView glSurfaceView;
    private TouchDispatcher touchDispatcher;
    private AudioFactory audioFactory;
    private boolean frameSuccess = true;

    private FPSCounter fpsCounter = new FPSCounter();
    private EventQueue eventQueue = new EventQueue();

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

        V8 runtime = V8.createV8Runtime();
        GLObjects glObjects = new GLObjects(runtime);
        Files files = new Files(this.context,runtime,glObjects,eventQueue);
        touchDispatcher = new TouchDispatcher(runtime);
        audioFactory = new AudioFactory(runtime,files);
        runtime.executeVoidScript(String.format("innerWidth = %d;innerHeight = %d;",widthPixels,heightPixels));
        Bindings.bindObjectToV8(runtime,new Console(context,runtime),"console");
        Bindings.bindObjectToV8(runtime,new WebGLRenderingContext(runtime,glObjects,files),"_globalGL");
        Bindings.bindObjectToV8(runtime,files,"_files");
        Bindings.bindObjectToV8(runtime,audioFactory,"_audioFactory");
        SurfaceResizer surfaceResizer = new SurfaceResizer(context,glSurfaceView);
        Bindings.bindObjectToV8(runtime,surfaceResizer,"_surfaceResizer");
        runtime.executeVoidScript(files.loadAssetAsString("primer.js"));
        try {
            runtime.executeVoidScript(files.loadAssetAsString("out/"+ MainActivity.assetName +".js"));
        } catch (Exception e) {
            e.printStackTrace();
            String error = ""+e.getMessage();
            Log.e("APP",error);
            ((MainActivity)(context)).goToCrashActivity(error);
            return;
        }
        renderCallBack = (V8Function)runtime.executeObjectScript("_requestAnimationFrameGlobalCallBack");
        this.runtime = runtime;

    }

    public void onDrawFrame(GL10 unused) {
        if (!frameSuccess) return;
        long begin = System.currentTimeMillis();
        //Log.d("APP","begin "+begin);
        if (renderCallBack!=null) {
            try {
                renderCallBack.call(runtime,null);
                touchDispatcher.nextTick();
                audioFactory.nextTick();
                eventQueue.nextTick();
                long end = System.currentTimeMillis();
                //Log.d("APP","end "+end);
                //Log.d("APP","passed " + (end - begin));
                fpsCounter.logFrame();
                glSurfaceView.requestRender();
            } catch (Exception e) {
                e.printStackTrace();
                frameSuccess = false;
                ((MainActivity)(context)).goToCrashActivity(e.getMessage());
            }

        }

    }

    @SuppressLint("DefaultLocale")
    public void onSurfaceChanged(GL10 unused, int width, int height) {
//        GLES20.glViewport(0, 0, width, height);
//        if (runtime!=null) {
//            runtime.executeVoidScript(String.format("innerWidth = %d;innerHeight = %d;",width,height));
//            runtime.executeVoidScript("_triggerEvent('resize')");
//        }
    }

    public void dispatchEvent(float x,float y, int touchId, String eventName){
        if (touchDispatcher!=null) touchDispatcher.dispatch(x,y,touchId,eventName);
    }

    public void destroy(){
        frameSuccess = false;
        audioFactory.destroy();
    }

}