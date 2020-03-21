package com.example.myapplicationj2v82.html5_objects;

import android.util.Log;

public class Console {

    public void log(Object ...args) {
        if (args==null) return;
        String s = "";
        for (Object arg : args) {
            s = s.concat(arg.toString()).concat(" ");
        }
        Log.d("VE",s);
    }

    public void error(Object ...args) {
        log(args);
    }

    public void trace(Object ...args) {
        log(args);
    }

}
