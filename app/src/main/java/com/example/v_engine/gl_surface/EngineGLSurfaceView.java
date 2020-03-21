package com.example.v_engine.gl_surface;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class EngineGLSurfaceView extends GLSurfaceView {


    public EngineGLSurfaceView(Context context) {
        super(context);
        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);
        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(new EngineGLRenderer(context,this));
        //setRenderer(new MyRenderer());
        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

}
