package com.example.v_engine.gl_surface;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class EngineGLSurfaceView extends GLSurfaceView implements View.OnTouchListener {

    private EngineGLRenderer engineGLRenderer;

    public EngineGLSurfaceView(Context context) {
        super(context);
        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);
        // Set the Renderer for drawing on the GLSurfaceView
        engineGLRenderer = new EngineGLRenderer(context,this);
        setRenderer(engineGLRenderer);
        setOnTouchListener(this);
        //setRenderer(new MyRenderer());
        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                engineGLRenderer.dispatchEvent(e.getX(),e.getY(),0,"ontouchstart");
                break;
            case MotionEvent.ACTION_MOVE:
                engineGLRenderer.dispatchEvent(e.getX(),e.getY(),0,"ontouchmove");
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                engineGLRenderer.dispatchEvent(e.getX(),e.getY(),0,"ontouchend");
                break;
        }
        return true;
    }
}
