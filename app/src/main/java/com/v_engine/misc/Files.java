package com.v_engine.misc;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.SparseArray;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.v_engine.misc.event_queue.EventQueue;
import com.v_engine.misc.event_queue.EventQueueTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Files {

    private static SparseArray<Bitmap> bitmapCache = new SparseArray<>();
    private static int cnt;

    private Context context;
    private V8 runtime;
    private GLObjects glObjects;
    private EventQueue eventQueue;

    private String processLocalUrl(String url){
        if (url.startsWith("./")) url = url.replace("./","");
        if (url.contains("?")) url = url.split("\\?")[0];
        return url;
    }

    public Files(Context context, V8 runtime, GLObjects glObjects, EventQueue eventQueue) {
        this.context = context;
        this.runtime = runtime;
        this.glObjects = glObjects;
        this.eventQueue = eventQueue;
    }

    public String loadAssetAsString(String fileName) {
        fileName = processLocalUrl(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName)));
            StringBuilder out= new StringBuilder();
            String eachline = bufferedReader.readLine();
            while (eachline != null) {
                out.append(eachline);
                out.append("\n");
                eachline = bufferedReader.readLine();
            }
            return out.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public V8Array loadAssetAsBinary(String fileName) throws IOException {
        fileName = processLocalUrl(fileName);
        InputStream inputStream = context.getAssets().open(fileName);
        byte[] fileBytes=new byte[inputStream.available()];
        inputStream.read(fileBytes);
        inputStream.close();
        V8Array v8Array = new V8Array(this.runtime);
        for (byte fileByte : fileBytes) {
            v8Array.push(fileByte);
        }
        return v8Array;
    }

    private static Bitmap convertString64ToImage(String base64String) {
        byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

    public void loadAssetAsImage(final String fileName, final V8Function success) {
        final V8Function successTwined = success.twin();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String fileNameProcessed = processLocalUrl(fileName);
                final Bitmap bitmap;
                if (fileNameProcessed.startsWith("data:image") && fileNameProcessed.contains(",")) bitmap = convertString64ToImage(fileNameProcessed.split(",")[1]);
                else {
                    InputStream inputStream;
                    try {
                        inputStream = context.getAssets().open(fileNameProcessed);
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                    bitmap = BitmapFactory.decodeStream(inputStream);
                }
                eventQueue.addTask(new EventQueueTask() {
                    @Override
                    public void doTask() {
                        int id = cnt++;
                        V8Object v8Object = glObjects.create(id);
                        v8Object.add("width",bitmap.getWidth());
                        v8Object.add("height",bitmap.getHeight());
                        bitmapCache.put(id,bitmap);
                        V8Array args = new V8Array(runtime);
                        args.push(v8Object);
                        successTwined.call(runtime,args);
                        successTwined.release();
                    }
                });
            }
        }).start();
    }

    public AssetFileDescriptor loadAssetAsAudio(String fileName) {
        fileName = processLocalUrl(fileName);
        try {
            return context.getAssets().openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Bitmap getCachedBitmap(V8Object object){
        return bitmapCache.get(glObjects.getId(object));
    }


}