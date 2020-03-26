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
    private AudioFactory audioFactory;

    public static Audio findById(int id){
        return audios.get(id);
    }

    public Audio(AssetFileDescriptor fileDescriptor,AudioFactory factory) {
        id = cnt++;
        this.audioFactory = factory;
        audios.put(id,this);
        try {
            mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),fileDescriptor.getStartOffset(),fileDescriptor.getLength());
            mediaPlayer.prepare();
            mediaPlayer.setOnCompletionListener(this);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
        audioFactory.onCompletion(id);
    }

    public void play(){
        mediaPlayer.start();
    }

    public void stop(){
        mediaPlayer.stop();
    }

    public int getId(){
        return id;
    }

}
