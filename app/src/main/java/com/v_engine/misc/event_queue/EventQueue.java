package com.v_engine.misc.event_queue;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EventQueue {

    private List<EventQueueTask> tasks = new ArrayList<>();

    private boolean dirty = false;

    public void addTask(EventQueueTask task) {
        this.dirty = true;
        synchronized (this) {
            tasks.add(task);
        }
    }

    public void nextTick(){
        if (!dirty) return;
        this.dirty = false;
        synchronized(this) {
            Iterator<EventQueueTask> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                EventQueueTask task = iterator.next();
                task.doTask();
                iterator.remove();
            }
        }

    }


}
