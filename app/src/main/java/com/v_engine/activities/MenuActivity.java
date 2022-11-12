package com.v_engine.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.v_engine.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends Activity implements AdapterView.OnItemClickListener {

    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ListView listView = findViewById(R.id.listView);
        try {
            String[] files = getAssets().list("out");
            for (String file : files) {
                list.add(file.split("[.]")[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, this.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    private boolean isExists(String file){
        AssetManager mg = getResources().getAssets();
        InputStream is = null;
        try {
            is = mg.open(file);
            return true;
            //File exists so do something with it
        } catch (IOException ex) {
            //file does not exist
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String assetName = list.get(position);
        if (!isExists("out/"+assetName+".js")) return;
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("assetName", assetName);
        this.startActivity(intent);
    }
}
