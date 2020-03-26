package com.v_engine.misc;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseArray;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

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

    private String processLocalUrl(String url){
        if (url.startsWith("./")) url = url.replace("./","");
        if (url.contains("?")) url = url.split("\\?")[0];
        return url;
    }

    public Files(Context context, V8 runtime, GLObjects glObjects) {
        this.context = context;
        this.runtime = runtime;
        this.glObjects = glObjects;
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

    public V8Array loadAssetAsBinary(String fileName) {
        fileName = processLocalUrl(fileName);
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            byte[] fileBytes=new byte[inputStream.available()];
            inputStream.read(fileBytes);
            inputStream.close();
            V8Array v8Array = new V8Array(this.runtime);
            for (byte fileByte : fileBytes) {
                v8Array.push(fileByte);
            }
            return v8Array;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public V8Object loadAssetAsImage(String fileName) {
        fileName = processLocalUrl(fileName);
        try {
            int id = cnt++;
            InputStream inputStream = context.getAssets().open(fileName);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            V8Object v8Object = glObjects.create(id);
            v8Object.add("width",bitmap.getWidth());
            v8Object.add("height",bitmap.getHeight());
            bitmapCache.put(id,bitmap);
            return v8Object;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
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