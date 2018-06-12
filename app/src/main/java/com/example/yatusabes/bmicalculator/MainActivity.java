package com.example.yatusabes.bmicalculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerNonConfig;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    OutputFragment mOutputFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getResources().getBoolean(R.bool.two_panel)) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            InputFragment input = new InputFragment();
            input.setActivity(this);
            mOutputFragment = new OutputFragment();
            mOutputFragment.setActivity(this);
            transaction.replace(R.id.input_pane, input);
            transaction.replace(R.id.output_pane, mOutputFragment);
            transaction.commit();
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            InputFragment input = new InputFragment();
            input.setActivity(this);
            mOutputFragment = new OutputFragment();
            mOutputFragment.setActivity(this);
            transaction.replace(R.id.content, input);
            transaction.commit();
        }
    }

    public void displayOutput(double bmi) {
        if (!getResources().getBoolean(R.bool.two_panel)) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.addToBackStack(null);
            transaction.replace(R.id.content, mOutputFragment);
            transaction.commit();
        }
        mOutputFragment.displayResults(bmi);
    }
}







