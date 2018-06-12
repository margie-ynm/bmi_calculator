package com.example.yatusabes.bmicalculator;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OutputFragment extends Fragment {
    private double mBmi = 0;
    private View mView;
    private MainActivity mActivity;

    public OutputFragment() {
        // Required empty public constructor
    }

    public void setActivity(MainActivity activity) {
        mActivity = activity;
    }

    public void setValues(double bmi) {
        mBmi = bmi;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.fragment_output, container, false);
        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();
        updateDisplay();
    }

    private String bmiDescription(double bmi) {
        if (bmi < 18.5) {
            return mActivity.getResources().getString(R.string.underweight_bmi);
        } else if ((bmi >= 18.5) && (bmi <= 25.0)) {
            return mActivity.getResources().getString(R.string.normal_bmi);
        } else if ((bmi > 25) && (bmi <= 30)) {
            return mActivity.getResources().getString(R.string.overweight_bmi);
        } else {
            return mActivity.getResources().getString(R.string.obese_bmi);
        }

    }

    public void displayResults(double bmi) {
        mBmi = bmi;
        updateDisplay();
    }

    private void updateDisplay() {

        if (mView != null) {
            TextView answerField = (TextView) mView.findViewById(R.id.bmi_result);
            answerField.setText("" + mBmi);
            TextView descriptionField = (TextView) mView.findViewById(R.id.bmi_description);
            descriptionField.setText(bmiDescription(mBmi));
        }
    }
}
