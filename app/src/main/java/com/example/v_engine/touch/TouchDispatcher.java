package com.example.v_engine.touch;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;

public class TouchDispatcher {


    private final int MAX_TOUCHES = 10;
    private TouchEvent[] touchEvents = new TouchEvent[MAX_TOUCHES];
    private boolean clean = true;
    private V8 runtime;
    private V8Object globalCanvas;
    private V8Array v8Arguments;


    public TouchDispatcher(V8 runtime) {
        this.runtime = runtime;
        for (int i = 0; i < touchEvents.length; i++) {
            touchEvents[i] = new TouchEvent(runtime);
        }
        v8Arguments = new V8Array(runtime);
        v8Arguments.push(V8Value.UNDEFINED);
        v8Arguments.push(V8Value.UNDEFINED);
    }

    private TouchEvent getFreeTouchEvent(){
        for (TouchEvent touchEvent : touchEvents) {
            if (!touchEvent.isDirty()) {
                touchEvent.markDirty();
                this.clean = false;
                return touchEvent;
            }
        }
        return null;
    }

    public boolean isDirty() {
        return !clean;
    }


    public void dispatch(float x,float y,int id,String eventName) {
        TouchEvent touchEvent = getFreeTouchEvent();
        if (touchEvent==null) return;
        touchEvent.setClientX(x);
        touchEvent.setClientY(y);
        touchEvent.setPointerId(id);
        touchEvent.setEventName(eventName);
    }

    public void nextTick(){
        if (clean) return;
        if (globalCanvas==null) globalCanvas = runtime.getObject("_globalCanvas");
        for (TouchEvent touchEvent : touchEvents) {
            if (!touchEvent.isDirty()) return;
            v8Arguments.add("0",touchEvent.prepareAndGetNativeObject());
            ((V8Function)(globalCanvas.getObject(touchEvent.getEventName()))).call(runtime,v8Arguments);
            touchEvent.markClean();
        }
        this.clean = true;
    }

}
