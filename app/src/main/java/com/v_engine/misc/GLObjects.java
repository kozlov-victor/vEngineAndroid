package com.v_engine.misc;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;

public class GLObjects {

    private V8 runtime;

    public GLObjects(V8 runtime) {
        this.runtime = runtime;
    }

    public V8Object create(int id){
        V8Object object = new V8Object(runtime);
        object.add("id",id);
        return object;
    }

    public int getId(V8Object object) {
        return object.getInteger("id");
    }

}
