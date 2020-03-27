package com.v_engine.misc;

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
                if (field.getType()==int.class) {
                    obj.add(field.getName(),field.getInt(target));
                } else if (field.getType()==boolean.class){
                    obj.add(field.getName(),field.getBoolean(target));
                } else if (field.getType()==short.class){
                    obj.add(field.getName(),field.getShort(target));
                } else if (field.getType()==long.class){
                    obj.add(field.getName(),field.getLong(target));
                } else if (field.getType()==byte.class){
                    obj.add(field.getName(),field.getByte(target));
                } else if (field.getType()==char.class){
                    obj.add(field.getName(),field.getChar(target));
                } else if (field.getType()==double.class){
                    obj.add(field.getName(),field.getDouble(target));
                } else if (field.getType()==float.class){
                    obj.add(field.getName(),field.getFloat(target));
                } else throw new RuntimeException("can not bind field with type " + field.getType());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        runtime.add(globalJsName, obj);
    }

}
