package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormatSymbols;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinnerMonth, spinnerYear;
    Button btnSubmit;
    String[] months;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerMonth = findViewById(R.id.spinnerMonth);
        spinnerYear = findViewById(R.id.spinnerYear);
        btnSubmit = findViewById(R.id.btnSubmit);
        populateSpinnerMonth();
        populateSpinnerYear();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String month = spinnerMonth.getSelectedItem().toString();
                String year = spinnerYear.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, month + " ,"+ year, Toast.LENGTH_SHORT).show();
            }
        });
        spinnerMonth.setOnItemSelectedListener(this);
        spinnerYear.setOnItemSelectedListener(this);

    }

    private void populateSpinnerMonth() {
        months = new DateFormatSymbols().getMonths();
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, months);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(monthAdapter);

    }

    private void populateSpinnerYear() {
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner_year));
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(yearAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.spinnerMonth)
        {
            //String selectedMonth = parent.getSelectedItem().toString();
           // String selectedMonth = parent.getItemAtPosition(position).toString();
            String selectedMonth = months[position];

            Toast.makeText(this, "Selected: " + selectedMonth, Toast.LENGTH_SHORT ).show();



        }
        else if(parent.getId() == R.id.spinnerYear)
        {
            String selectedYear  = parent.getSelectedItem().toString();
            Toast.makeText(this, "Selected: " + selectedYear, Toast.LENGTH_SHORT ).show();

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}