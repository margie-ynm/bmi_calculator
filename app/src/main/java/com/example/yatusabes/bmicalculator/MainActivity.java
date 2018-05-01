package com.example.yatusabes.bmicalculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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




        try {
            weightInlbs = Double.parseDouble(weightString);
        }
        catch (Exception e) {
            Toast.makeText(this, "Please enter a numeric value for weight.", Toast.LENGTH_LONG).show();
            return;
        }

        // people who weigh less than a newborn do not need their BMI calculated
        if (weightInlbs < 10) {
            Toast.makeText(this, "Please enter a reasonable value for weight.", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            heightInfeet = Integer.parseInt(feetString);
        }
        catch (Exception e) {
            Toast.makeText(this, "Please enter a numeric value for height", Toast.LENGTH_LONG).show();
            return;
        }

        if ((heightInfeet < 1) || (heightInfeet > 8)) {
            Toast.makeText(this, "Please enter a reasonable value for height in feet.", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            heightInInches = Integer.parseInt(inchesString);
        }
        catch (Exception e) {
            Toast.makeText(this, "Please enter a numeric value for inches", Toast.LENGTH_LONG).show();
            return;
        }

        if ((heightInInches < 1) || (heightInInches > 12)) {
            Toast.makeText(this, "Please enter a reasonable value for height in inches.", Toast.LENGTH_LONG).show();
            return;
        }


        Integer height = heightInInches + heightInfeet * 12;


        double kilos = weightInlbs.doubleValue() / POUNDS_PER_KILO;
        double meters = height.doubleValue() / INCHES_PER_METER;

        Double bmi = kilos / Math.pow(meters, 2.0);

        bmi = Math.round(bmi * 10.0) / 10.0;


        TextView answerField = (TextView) findViewById(R.id.bmi_result);
        answerField.setText(bmi + "");

        
    }






}
