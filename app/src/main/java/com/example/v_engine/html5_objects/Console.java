package com.example.v_engine.html5_objects;

import android.util.Log;

public class Console {

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
        Log.e("VE",logsToStr(args));
    }

    public void trace(Object ...args) {
        Log.d("VE",logsToStr(args));
    }

}
