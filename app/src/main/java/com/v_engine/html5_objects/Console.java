package com.v_engine.html5_objects;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.v_engine.activities.CrashActivity;
import com.v_engine.activities.MainActivity;

public class Console {

    private Context context;

    public Console(Context context) {
        this.context = context;
    }

    private String logsToStr(Object ...args){
        if (args==null) return "undefined";
        String s = "";
        for (Object arg : args) {
            String toStr = arg==null?"null":arg.toString();
            s = s.concat(toStr).concat(" ");
        }
        return s;
    }

    public void log(Object ...args) {
        Log.d("VE",logsToStr(args));
    }

    public void error(Object ...args) {
        String error = logsToStr(args);
        Log.e("VE",error);
        ((MainActivity)(context)).goToCrashActivity(error);
    }

    public void trace(Object ...args) {
        Log.d("VE",logsToStr(args));
    }

}
