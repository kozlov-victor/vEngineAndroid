package com.v_engine.gl_surface;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

import com.v_engine.touch.TouchGLSurface;

public class EngineGLSurfaceView extends TouchGLSurface {

    private EngineGLRenderer engineGLRenderer;

    public EngineGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setEGLContextClientVersion(2);
        engineGLRenderer = new EngineGLRenderer(context,this);
        setRenderer(engineGLRenderer);
        setOnTouchListener(this);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override
    protected void dispatchEvent(float x, float y, int pointerID, String actionName) {
        engineGLRenderer.dispatchEvent(x, y, pointerID, actionName);
    }
}
