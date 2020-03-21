package com.example.myapplicationj2v82.misc;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Files {

    public static String loadAssetFile(Context context, String fileName) {
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


}