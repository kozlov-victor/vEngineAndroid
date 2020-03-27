package com.v_engine.audio;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.SparseArray;

import java.io.IOException;

public class Audio implements MediaPlayer.OnCompletionListener{

    private static int cnt = 0;
    private static SparseArray<Audio> audios = new SparseArray<>();

    private MediaPlayer mediaPlayer = new MediaPlayer();
    private int id;
    private boolean dirty = false;
    private AudioFactory audioFactory;

    public static Audio findById(int id){
        return audios.get(id);
    }

    public Audio(AudioFactory factory) {
        id = cnt++;
        this.audioFactory = factory;
        audios.put(id,this);
        mediaPlayer.setOnCompletionListener(this);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        this.dirty = true;
        mediaPlayer.reset();
        audioFactory.maskAsDirty();
    }

    public void maskAsClean(){
        this.dirty = false;
    }

    public boolean isDirty(){
        return this.dirty;
    }

    public void play(AssetFileDescriptor fileDescriptor){
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),fileDescriptor.getStartOffset(),fileDescriptor.getLength());
            mediaPlayer.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mediaPlayer.start();
    }

    public void stop(){
        mediaPlayer.stop();
    }

    public int getId(){
        return id;
    }

}
