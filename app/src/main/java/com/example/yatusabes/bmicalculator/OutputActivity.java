package com.example.yatusabes.bmicalculator;

import android.content.Intent;
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
    }
}
