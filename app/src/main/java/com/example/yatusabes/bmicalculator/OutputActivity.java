package com.example.yatusabes.bmicalculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        showOutput();
    }


    
    private void showOutput() {
        
        Intent intent = getIntent();
        
        Double bmi = intent.getDoubleExtra("Calculated BMI", 0);

        TextView answerField = (TextView) findViewById(R.id.bmi_result);
        answerField.setText(bmi.toString());

        TextView descriptionField = (TextView) findViewById(R.id.bmi_description);
        descriptionField.setText(bmiDescription(bmi));
    }

    private String bmiDescription(double bmi) {
        if (bmi < 18.5) {
            return "Underweight BMI";
        } else if ((bmi >= 18.5) && (bmi <= 25.0)) {
            return "Normal BMI";
        } else if ((bmi > 25 ) && (bmi <=30)) {
            return "Overweight BMI";
        } else {
            return "Obese BMI";
        }

    }
}
