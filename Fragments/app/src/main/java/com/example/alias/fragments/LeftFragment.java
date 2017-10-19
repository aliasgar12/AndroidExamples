package com.example.alias.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LeftFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LeftFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeftFragment extends Fragment implements View.OnClickListener{

    private OnColorChooseListener mListener;

    public LeftFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeftFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeftFragment newInstance() {
        LeftFragment fragment = new LeftFragment();
        return fragment;
    }


//    @Override
//    public void onAttach(Acitvity acitvity) {
//        super.onAttach(activity);
//        mListener = (OnColorChooseListener) activity;
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity)context;
        mListener = (OnColorChooseListener)activity;
//

        //Activity a;

        //

        //if (context instanceof Activity){

        //a=(Activity) context;

        //}

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.left_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view , Bundle savedInstanceState){

        Button redButton = (Button) view.findViewById(R.id.redButton);
        Button blueButton = (Button) view.findViewById(R.id.blueButton);
        Button greenButton = (Button) view.findViewById(R.id.greenButton);

        redButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);



    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.blueButton:
                updateDisplay(Color.BLUE);
                break;
            case R.id.redButton:
                updateDisplay(Color.RED);
                break;
            case R.id.greenButton:
                updateDisplay(Color.GREEN);
                break;
        }


    }

    private void updateDisplay(int color) {
        mListener.onColorChosen(color);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnColorChooseListener {
        // TODO: Update argument type and name
        void onColorChosen(int color);
    }
}
