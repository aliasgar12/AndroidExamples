package com.example.alias.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RightFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RightFragment extends Fragment {

    public static final String ARG_COLOR = "color";

    public RightFragment() {
        // Required empty public constructor
    }

    public static RightFragment newInstance(int color) {
        RightFragment fragment = new RightFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.right_fragment, container, false);
    }

    @Override

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            int color = getArguments().getInt(ARG_COLOR);

            switch (color) {
                case Color.RED:
                    view.findViewById(R.id.redView).setBackgroundColor(Color.RED);
                    break;
                case Color.BLUE:
                    view.findViewById(R.id.blueView).setBackgroundColor(Color.BLUE);
                    break;
                case Color.GREEN:
                    view.findViewById(R.id.greenView).setBackgroundColor(Color.GREEN);
                    break;
            }
        }
    }
}
