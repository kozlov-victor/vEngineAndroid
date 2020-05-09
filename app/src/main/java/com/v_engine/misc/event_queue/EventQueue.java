package com.v_engine.misc.event_queue;


import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EventQueue {

    private List<EventQueueTask> tasks = new ArrayList<>();
    private V8 runtime;

    private boolean dirty = false;


    public EventQueue(V8 runtime) {
        this.runtime = runtime;
    }

    public void addTask(EventQueueTask task) {
        this.dirty = true;
        synchronized (this) {
            tasks.add(task);
        }
    }


    public void executeOnNextTask(V8Function function){
        final V8Function tweened = function.twin();
        new Thread(new Runnable() {
            @Override
            public void run() {
                addTask(new EventQueueTask() {
                    @Override
                    public void doTask() {
                        V8Array args = new V8Array(runtime);
                        tweened.call(runtime,args);
                        tweened.release();
                        args.release();
                    }
                });
            }
        }).start();
    }

    public void nextTick(){
        if (!dirty) return;
        this.dirty = false;
        synchronized(this) {
            for (Iterator<EventQueueTask> iterator = tasks.iterator(); iterator.hasNext();) {
                EventQueueTask task = iterator.next();
                task.doTask();
                iterator.remove();
            }
        }

    }


}
