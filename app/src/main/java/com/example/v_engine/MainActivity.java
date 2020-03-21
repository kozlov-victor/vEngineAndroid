package com.example.v_engine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.v_engine.gl_surface.EngineGLSurfaceView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EngineGLSurfaceView(this));
    }
}
