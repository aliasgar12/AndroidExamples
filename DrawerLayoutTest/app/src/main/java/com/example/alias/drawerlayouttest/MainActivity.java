package com.example.alias.drawerlayouttest;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mColors[] = new String[]{"Red" , "Green" , "Blue"};
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        ListView drawerList = (ListView) findViewById(R.id.left_drawer);


        drawerList.setAdapter(new ArrayAdapter<>(this, R.layout.list_row , mColors));

        drawerList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        int color = -1;
        switch(position){
            case 0:
                color = Color.RED;
                break;
            case 1:
                color= Color.GREEN;
                break;
            case 2:
                color = Color.BLUE;
                break;
        }


        getSupportFragmentManager().beginTransaction().
                replace(R.id.content_frame, ColorFragment.newInstance(color)).commit();

        if(mDrawerLayout.isShown()){
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        }
    }
}
