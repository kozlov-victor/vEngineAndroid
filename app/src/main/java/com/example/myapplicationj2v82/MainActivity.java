package com.example.myapplicationj2v82;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.eclipsesource.v8.V8;
import com.example.myapplicationj2v82.gl_surface.EngineGLSurfaceView;
import com.example.myapplicationj2v82.misc.Bindings;
import com.example.myapplicationj2v82.html5_objects.Console;
import com.example.myapplicationj2v82.misc.Files;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EngineGLSurfaceView(this));
    }
}
