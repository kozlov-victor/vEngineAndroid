package com.v_engine.touch;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;

public class TouchEvent {

    private boolean dirty;

    private float clientX;
    private float clientY;
    private int pointerId;
    private String eventName;
    private V8Array v8Touches; // e.touches.length;
    private V8Object v8TouchInfo; // e.touches.length;
    private V8Object v8TouchEvent; // e.touches.length;
    private V8 runtime;

    public TouchEvent(V8 runtime) {
        this.runtime = runtime;
        V8Function preventDefault = new V8Function(runtime, new JavaCallback() {
            @Override
            public Object invoke(V8Object v8Object, V8Array v8Array) {
                return null;
            }
        });
        v8TouchEvent = new V8Object(runtime);
        v8TouchInfo = new V8Object(runtime);
        v8Touches = new V8Array(runtime);

        v8TouchEvent.add("preventDefault",preventDefault);
        v8TouchEvent.add("touches",v8Touches);
        v8TouchEvent.add("changedTouches",v8Touches);
        v8Touches.add("0",v8TouchInfo);
    }

    public boolean isDirty(){
        return this.dirty;
    }

    public void markDirty(){
        this.dirty = true;
    }

    public void markClean(){
        this.dirty = false;
    }

    public float getClientX() {
        return clientX;
    }

    public void setClientX(float clientX) {
        this.clientX = clientX;
    }

    public float getClientY() {
        return clientY;
    }

    public void setClientY(float clientY) {
        this.clientY = clientY;
    }

    public int getPointerId() {
        return pointerId;
    }

    public void setPointerId(int pointerId) {
        this.pointerId = pointerId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public V8Object prepareAndGetNativeObject(){
        v8TouchInfo.add("clientX",clientX);
        v8TouchInfo.add("clientY",clientY);
        v8TouchInfo.add("pointerId",pointerId);
        return v8TouchEvent;
    }
}
