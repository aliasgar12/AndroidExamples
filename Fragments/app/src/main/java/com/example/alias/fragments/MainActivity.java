package com.example.alias.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LeftFragment.OnColorChooseListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LeftFragment leftFragment = LeftFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.leftFragment,leftFragment).commit();
    }

    @Override
    public void onColorChosen(int color) {
        RightFragment rightFragment = RightFragment.newInstance(color);
        getSupportFragmentManager().beginTransaction().replace(R.id.rightFragment, rightFragment).commit();
    }
}
