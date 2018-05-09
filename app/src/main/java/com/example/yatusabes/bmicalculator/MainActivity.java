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

    private TextView m_my_title;

    private static final String LOG_TAG = "InputActivity";
    private static final double POUNDS_PER_KILO = 2.20462;
    private static final double INCHES_PER_METER = 39.3701;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_my_title = (TextView) findViewById(R.id.my_title);
        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        m_my_title.setTypeface(ostrichFont);

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
            Log.e(LOG_TAG, "Invalid float from input for weight: " + weightString);
            Toast.makeText(this, R.string.numeric_value_for_weight, Toast.LENGTH_LONG).show();
            return;
        }

        // people who weigh less than a newborn do not need their BMI calculated
        if (weightInlbs < 10) {
            Toast.makeText(this, R.string.reasonable_value_for_weight, Toast.LENGTH_LONG).show();
            return;
        }

        try {
            heightInfeet = Integer.parseInt(feetString);
        }
        catch (Exception e) {
            Log.e(LOG_TAG, "Invalid integer from input for number of feet: " + feetString);
            Toast.makeText(this, R.string.valid_number_value_height, Toast.LENGTH_LONG).show();
            return;
        }

        if ((heightInfeet < 1) || (heightInfeet > 8)) {
            Toast.makeText(this, R.string.reasonable_value_height_feet, Toast.LENGTH_LONG).show();
            return;
        }

        try {
            heightInInches = Integer.parseInt(inchesString);
        }
        catch (Exception e) {
            Log.e(LOG_TAG, "Invalid integer from input for inches: " + inchesString);
            Toast.makeText(this, R.string.valid_number_inches, Toast.LENGTH_LONG).show();
            return;
        }

        if ((heightInInches < 0) || (heightInInches > 11)) {
            Toast.makeText(this, R.string.reasonable_value_inches, Toast.LENGTH_LONG).show();
            return;
        }


        Integer height = heightInInches + heightInfeet * 12;


        double kilos = weightInlbs.doubleValue() / POUNDS_PER_KILO;
        double meters = height.doubleValue() / INCHES_PER_METER;

        Double bmi = kilos / Math.pow(meters, 2.0);

        bmi = Math.round(bmi * 10.0) / 10.0;


        Intent intent = new Intent(this, OutputActivity.class);

        intent.putExtra("Calculated BMI", bmi);
        startActivity(intent);
    }






}
