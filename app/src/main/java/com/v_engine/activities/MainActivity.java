package com.v_engine.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.v_engine.R;
import com.v_engine.gl_surface.EngineGLSurfaceView;

public class MainActivity extends AppCompatActivity {

    public static String assetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        assetName = intent.getStringExtra("assetName");

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void goToCrashActivity(String error){
        Intent intent = new Intent(this, CrashActivity.class);
        intent.putExtra("error", error);
        this.startActivity(intent);
        finish();
    }

}
