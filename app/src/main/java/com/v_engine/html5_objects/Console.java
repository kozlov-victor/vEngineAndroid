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
        if (object==null) return null;
        else if (object instanceof String) return (String)object;
        else if (object instanceof V8Object) {
            V8Object v8Object = (V8Object)object;
            V8Object json = runtime.getObject("JSON");

            V8Array parameters = new V8Array(runtime).push(v8Object);
            try {
                return json.executeStringFunction("stringify", parameters);
            } catch (Exception e) {
                e.printStackTrace();
                return object.toString();
            } finally {
                parameters.release();
                json.release();
                v8Object.release();
            }
        } else {
            return object.toString();
        }

    }

    private String logsToStr(Object ...args){
        if (args==null) return "undefined";
        Log.e("VE",""+args[0]);
        String s = "";
        for (Object arg : args) {
            String toStr = stringify(arg);
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
