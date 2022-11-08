package com.v_engine.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;



import com.example.v_engine.R;

public class CrashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);
        String error = getIntent().getStringExtra("error");
        TextView textView = (TextView)findViewById(R.id.textViewCrash);
        textView.setText(error);
    }
}
