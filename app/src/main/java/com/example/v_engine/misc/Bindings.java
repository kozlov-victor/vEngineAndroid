package com.example.v_engine.misc;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Bindings {

    public static void bindObjectToV8(V8 runtime, Object target, String globalJsName){
        V8Object obj = new V8Object(runtime);
        Method[] methods = target.getClass().getMethods();
        for (Method m : methods) {
            obj.registerJavaMethod(target, m.getName(), m.getName(), m.getParameterTypes());
        }
        Field[] fields = target.getClass().getFields();
        for (Field field : fields) {
            try {
                obj.add(field.getName(),field.getInt(target));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        runtime.add(globalJsName, obj);
    }

}
