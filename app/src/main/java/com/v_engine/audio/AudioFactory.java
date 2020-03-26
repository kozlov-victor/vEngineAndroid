package com.v_engine.audio;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.v_engine.misc.Files;

public class AudioFactory {

    private Files files;
    private V8Function onAudioEnded;
    private V8 runtime;
    private V8Array args;

    public AudioFactory(V8 runtime,Files files) {
        this.runtime = runtime;
        this.files = files;
        args = new V8Array(runtime);
    }

    public int createAudio(String url){
        Audio audio = new Audio(files.loadAssetAsAudio(url),this);
        return audio.getId();
    }

    void onCompletion(int id) {
        if (onAudioEnded!=null) {
            args.add("0",id);
            onAudioEnded.call(runtime,args);
        }
    }

    public void play(int id) {
        Audio.findById(id).play();
    }

    public void stop(int id) {
        Audio.findById(id).stop();
    }

    public void setOnAudioEnded(V8Function callback) {
        this.onAudioEnded = callback;
    }

}
