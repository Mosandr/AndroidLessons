package com.example.clubolympus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class Addmember extends AppCompatActivity {

    private EditText nameEditText;
    private EditText surnameEditText;
    private EditText groupEditText;
    private Spinner genderSpinner;
    private int gender = 0;
    private ArrayAdapter<CharSequence> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmember);

        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        groupEditText = findViewById(R.id.groupEditText);
        genderSpinner = findViewById(R.id.genderSpinner);

         spinnerAdapter= ArrayAdapter.createFromResource(
                this, R.array.array_gender, android.R.layout.simple_spinner_item);
         spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         genderSpinner.setAdapter(spinnerAdapter);
    }
}
