package com.v_engine.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.v_engine.R;

public class CrashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);
        String error = getIntent().getStringExtra("error");
        TextView textView = findViewById(R.id.textViewCrash);
        textView.setText(error);
    }
}
