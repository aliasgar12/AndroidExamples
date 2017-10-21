package com.example.alias.listviewtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by alias on 1/29/2017.
 */

public class ImageAdapter extends BaseAdapter {

    public MainActivity mainActivity;

    public ImageAdapter(MainActivity mainActivity){this.mainActivity= mainActivity;}

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(mainActivity).inflate(R.layout.list_row,parent,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(mainActivity.getResources().getIdentifier("p" + (position + 1),
                "drawable", mainActivity.getPackageName()));


        return view;
    }
}
