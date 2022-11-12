package com.v_engine.gl_surface;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.ViewGroup;

public class SurfaceResizer {

    private GLSurfaceView surfaceView;
    private Context context;

    public SurfaceResizer(Context context, GLSurfaceView surfaceView) {
        this.surfaceView = surfaceView;
        this.context = context;
    }

    public void setWidth(final int width){
        ((Activity)context).runOnUiThread(() -> {
            ViewGroup.LayoutParams params = surfaceView.getLayoutParams();
            params.width = width;
            surfaceView.setLayoutParams(params);
        });
    }

    public void setHeight(final int height){
        ((Activity)context).runOnUiThread(() -> {
            ViewGroup.LayoutParams params = surfaceView.getLayoutParams();
            params.height = height;
            surfaceView.setLayoutParams(params);
        });
    }

}
