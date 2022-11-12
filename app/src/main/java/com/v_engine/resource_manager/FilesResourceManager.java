package com.v_engine.resource_manager;

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
import com.v_engine.misc.GLObjects;
import com.v_engine.misc.event_queue.EventQueue;
import com.v_engine.misc.event_queue.EventQueueTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FilesResourceManager {

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

    public FilesResourceManager(Context context, V8 runtime, GLObjects glObjects, EventQueue eventQueue) {
        this.context = context;
        this.runtime = runtime;
        this.glObjects = glObjects;
        this.eventQueue = eventQueue;
    }

    public String loadAssetAsStringSync(String fileName){
        String fileNameProcessed = processLocalUrl(fileName);
        StringBuilder out= new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileNameProcessed)));
            String eachline = bufferedReader.readLine();
            while (eachline != null) {
                out.append(eachline);
                out.append("\n");
                eachline = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return out.toString();
    }

    public void loadAssetAsString(final String fileName, V8Function success, final V8Function error) {
        final V8Function successTwined = success.twin();
        final V8Function errorTwined = error.twin();
        new Thread(new Runnable() {
            @Override
            public void run() {
                eventQueue.addTask(new EventQueueTask() {
                    @Override
                    public void doTask() {

                        try {
                            final String result = loadAssetAsStringSync(fileName);

                            V8Array args = new V8Array(runtime);
                            args.push(result);
                            successTwined.call(runtime,args);
                            successTwined.release();
                            args.release();
                        } catch (Exception e) {
                            V8Array args = new V8Array(runtime);
                            args.push(e.getMessage());
                            errorTwined.call(runtime,args);
                            errorTwined.release();
                            args.release();
                        }

                    }
                });

            }
        }).start();

    }

    public void loadAssetAsBinary(final String fileName, V8Function success, final V8Function error)  {
        final V8Function successTwined = success.twin();
        final V8Function errorTwined = error.twin();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String fileNameProcessed = processLocalUrl(fileName);
                InputStream inputStream = null;
                try {
                    inputStream = context.getAssets().open(fileNameProcessed);
                    final byte[] fileBytes=new byte[inputStream.available()];
                    inputStream.read(fileBytes);
                    inputStream.close();
                    eventQueue.addTask(new EventQueueTask() {
                        @Override
                        public void doTask() {
                            V8Array bytes = new V8Array(runtime);
                            for (byte fileByte : fileBytes) {
                                bytes.push(fileByte);
                            }
                            V8Array args = new V8Array(runtime);
                            args.push(bytes);
                            successTwined.call(runtime,args);
                            successTwined.release();
                            args.release();
                        }
                    });
                } catch (IOException e) {
                    V8Array args = new V8Array(runtime);
                    args.push(e.getMessage());
                    errorTwined.call(runtime,args);
                    errorTwined.release();
                    args.release();
                    e.printStackTrace();
                }


            }
        }).start();

    }

    private static Bitmap convertString64ToImage(String base64String) {
        byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

    public void loadAssetAsImage(final String fileName, final V8Function success,final V8Function error) {
        final V8Function successTwined = success.twin();
        final V8Function errorTwined   = error==null?null:error.twin();
        new Thread(new Runnable() {
            @Override
            public void run() {
                eventQueue.addTask(new EventQueueTask() {
                    @Override
                    public void doTask() {

                        String fileNameProcessed = processLocalUrl(fileName);
                        final Bitmap bitmap;
                        if (fileNameProcessed.startsWith("data:image") && fileNameProcessed.contains(",")) bitmap = convertString64ToImage(fileNameProcessed.split(",")[1]);
                        else {
                            InputStream inputStream;
                            try {
                                inputStream = context.getAssets().open(fileNameProcessed);
                            } catch (IOException e) {
                                e.printStackTrace();
                                if (errorTwined!=null) {
                                    V8Array args = new V8Array(runtime);
                                    args.push(e.getMessage());
                                    errorTwined.call(runtime,args);
                                    errorTwined.release();
                                    args.release();
                                    return;
                                } else {
                                    throw new RuntimeException(e);
                                }

                            }
                            bitmap = BitmapFactory.decodeStream(inputStream);
                        }

                        int id = cnt++;
                        V8Object v8Object = glObjects.create(id);
                        v8Object.add("width",bitmap.getWidth());
                        v8Object.add("height",bitmap.getHeight());
                        bitmapCache.put(id,bitmap);
                        V8Array args = new V8Array(runtime);
                        args.push(v8Object);
                        successTwined.call(runtime,args);
                        successTwined.release();
                        args.release();
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