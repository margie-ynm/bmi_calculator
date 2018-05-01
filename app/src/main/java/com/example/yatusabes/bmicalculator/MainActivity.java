package com.example.yatusabes.bmicalculator;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double POUNDS_PER_KILO = 2.20462;
    double INCHES_PER_METER = 39.3701;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void calculateBMI(View view) {
        Double weightInlbs = 0.0;
        Integer heightInfeet = 0;
        Integer heightInInches = 0;

        EditText weightEditText = (EditText) findViewById(R.id.weight_input);
        EditText feetEditText = (EditText) findViewById(R.id.feet_input);
        EditText inchesEditText = (EditText) findViewById(R.id.inches_input);

        String weightString = weightEditText.getText().toString();
        String feetString = feetEditText.getText().toString();
        String inchesString = inchesEditText.getText().toString();


        weightInlbs = Double.parseDouble(weightString);
        heightInfeet = Integer.parseInt(feetString);
        heightInInches = Integer.parseInt(inchesString);


        Integer height = heightInInches + heightInfeet * 12;


        double kilos = weightInlbs.doubleValue() / POUNDS_PER_KILO;
        double meters = height.doubleValue() / INCHES_PER_METER;

        double bmi = kilos / Math.pow(meters, 2.0);

        bmi = Math.round(bmi * 10.0) / 10.0;


        TextView answerField = (TextView) findViewById(R.id.bmi_result);
        answerField.setText(bmi + "");
    }






}
