package com.v_engine.audio;

import android.content.res.AssetFileDescriptor;
import android.util.Log;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.v_engine.misc.Files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AudioFactory {

    private Files files;
    private V8 runtime;
    private V8Array args;
    private boolean dirty = false;
    private List<Audio> audioList = new ArrayList<>();

    private Map<String, AssetFileDescriptor> audioLoaded = new HashMap<>();

    public AudioFactory(V8 runtime,Files files) {
        this.runtime = runtime;
        this.files = files;
        args = new V8Array(runtime);
    }

    public int createAudio(V8Object v8Audio){
        Audio audio = new Audio(this, v8Audio);
        audioList.add(audio);
        return audio.getId();
    }

    private AssetFileDescriptor getAssetByUrl(String url) {
        AssetFileDescriptor possible = audioLoaded.get(url);
        if (possible!=null) return possible;
        possible = files.loadAssetAsAudio(url);
        audioLoaded.put(url,possible);
        return possible;
    }

    public void play(int id, String url) {
        try {
            Audio.findById(id).play(getAssetByUrl(url));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("APP","can not play audio: " + url);
        }
    }

    public void setLoop(int id, boolean loop) {
        Audio.findById(id).setLoop(loop);
    }

    public void stop(int id) {
        Audio.findById(id).stop();
    }

    void maskAsDirty(){
        this.dirty = true;
    }

    public void nextTick() {
        if (!dirty) return;
        int possibleIndexToDelete = -1;
        for (int i = 0; i < audioList.size(); i++) {
            Audio audio = audioList.get(i);
            if (audio.isDirty()) {
                V8Object a = audio.getV8Audio();
                if (a.isReleased()) {
                    possibleIndexToDelete = i;
                    continue;
                }
                V8Function callback = (V8Function) a.getObject("onended");
                if (callback != null) {
                    args.add("0", audio.getId());
                    callback.call(runtime, args);
                }
                audio.maskAsClean();
            }
        }
        if (possibleIndexToDelete>-1) audioList.remove(possibleIndexToDelete);
        dirty = false;
    }

    public void destroy() {
        for (int i = 0; i < audioList.size(); i++) {
            Audio audio = audioList.get(i);
            audio.destroy();
        }
    }

}
