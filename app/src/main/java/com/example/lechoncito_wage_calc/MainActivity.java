package com.example.lechoncito_wage_calc;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextHourlyRate;
    private EditText editTextHoursWorked;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextHourlyRate = findViewById(R.id.editTextWage);
        editTextHoursWorked = findViewById(R.id.editTextWorkingHours);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);


        buttonCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonCalculate) {
            calculateWage();
        }
    }

    private void calculateWage() {
        // Get the input values
        String hourlyRateStr = editTextHourlyRate.getText().toString().trim();
        String hoursWorkedStr = editTextHoursWorked.getText().toString().trim();

        // Check if the input values are not empty
        if (hourlyRateStr.isEmpty() || hoursWorkedStr.isEmpty()) {
            textViewResult.setText("Please enter hourly rate and hours worked");
            return;
        }


        double hourlyRate = Double.parseDouble(hourlyRateStr);
        double hoursWorked = Double.parseDouble(hoursWorkedStr);


        double wage = hourlyRate * hoursWorked;


        textViewResult.setText("Wage: $" + wage);
    }
}