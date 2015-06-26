package com.davidkopala.ozoneconversion;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Fragment implements View.OnClickListener {

    String[] titles = new String[]{
            "Flow Rate",
            "Feed Gas",
            "Dry",
            "Generator",
            "PPM",
            "Adjusted Flow"
    };

    String[] titleA = new String[]{
            "GPM",
            "SLPM",
            "SLPM",
            "SLPM",
            "CFM",
            "PSI"
    };

    String[] titleB = new String[]{
            "PPM",
            "% O3",
            "% O3",
            "g/m3",
            "PPM",
            "Measured Flow"
    };

    Conversion conversion = new Conversion();

    public int index = -1;
    private View rootView;

    TextView title01;
    EditText input01;

    TextView title02;
    EditText input02;

    Button submit;

    TextView result;

    private OnFragmentInteractionListener mListener;

    public static Main newInstance(int position) {
        Main fragment = new Main(position);
        return fragment;
    }

    public Main(int position) {
        // Required empty public constructor
        index = position;
    }

    /*public Main() {

    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        submit = (Button) rootView.findViewById(R.id.submitButton);
        submit.setOnClickListener(this);

        title01 = (TextView) rootView.findViewById(R.id.title01);
        input01 = (EditText) rootView.findViewById(R.id.input01);

        title02 = (TextView) rootView.findViewById(R.id.title02);
        input02 = (EditText) rootView.findViewById(R.id.input02);

        result = (TextView) rootView.findViewById(R.id.result);

        title01.setText(titleA[index]);
        title02.setText(titleB[index]);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void submit(View view) {

    }

    @Override
    public void onClick(View view) {
        String stringResult;
        String A = input01.getText().toString();
        String B = input02.getText().toString();
        switch (index) {
            case 0:
                stringResult = conversion.flowRateAndPPMWater(A, B);
                break;
            case 1:
                stringResult = conversion.OutputOzoneGeneratorFeedgas(A, B);
                break;
            case 2:
                stringResult = conversion.OutputOzoneGeneratorDry(A, B);
                break;
            case 3:
                stringResult = conversion.OutputOzoneGenerator(A, B);
                break;
            case 4:
                stringResult = conversion.OutputOzoneGeneratorPPM(A, B);
                break;
            case 5:
                stringResult = conversion.AdjustedFlow(A, B);
                break;
            default:
                stringResult = "Error";
        }
        result.setText(stringResult);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
