package com.v_engine.html5_objects;

import android.content.Context;
import android.util.Log;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.v_engine.activities.MainActivity;

public class Console {

    private Context context;
    private V8 runtime;

    public Console(Context context, V8 runtime) {
        this.context = context;
        this.runtime = runtime;
    }

    private String stringify(Object object) {
        if (!(object instanceof V8Object)) return object.toString();
        V8Object v8Object = (V8Object)object;
        V8Object json = runtime.getObject("JSON");

        V8Array parameters = new V8Array(runtime).push(v8Object);
        String result = json.executeStringFunction("stringify", parameters);
        parameters.release();
        json.release();
        v8Object.release();
        return result;
    }

    private String logsToStr(Object ...args){
        if (args==null) return "undefined";
        String s = "";
        for (Object arg : args) {
            String toStr = arg==null?"null":stringify(arg);
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
