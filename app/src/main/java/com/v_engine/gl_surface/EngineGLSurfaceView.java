package com.v_engine.gl_surface;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import com.v_engine.touch.TouchGLSurfaceDelegate;

public class EngineGLSurfaceView extends GLSurfaceView {

    private EngineGLRenderer engineGLRenderer;

    public EngineGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setEGLContextClientVersion(2);
        engineGLRenderer = new EngineGLRenderer(context,this);
        setRenderer(engineGLRenderer);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    public void dispatchEvent(float x, float y, int pointerID, String actionName) {
        engineGLRenderer.dispatchEvent(x, y, pointerID, actionName);
    }

}
