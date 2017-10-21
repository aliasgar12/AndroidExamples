package com.example.alias.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView imageList = (ListView) findViewById(R.id.listView);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        imageList.setAdapter(imageAdapter);
    }
}
