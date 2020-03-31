package com.v_engine.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.v_engine.R;
import com.v_engine.gl_surface.EngineGLSurfaceView;
import com.v_engine.touch.TouchGLSurfaceDelegate;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    public static String assetName;
    private TouchGLSurfaceDelegate touchGLSurfaceDelegate;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        assetName = intent.getStringExtra("assetName");

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        EngineGLSurfaceView glSurfaceView = findViewById(R.id.engine_gl_surface_view);
        touchGLSurfaceDelegate = new TouchGLSurfaceDelegate(glSurfaceView);
        FrameLayout frameLayout = findViewById(R.id.engine_gl_frame_view);
        frameLayout.setOnTouchListener(this);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        touchGLSurfaceDelegate.onTouch(v,event);
        return true;
    }

    public void goToCrashActivity(String error){
        Intent intent = new Intent(this, CrashActivity.class);
        intent.putExtra("error", error);
        this.startActivity(intent);
        finish();
    }

}
