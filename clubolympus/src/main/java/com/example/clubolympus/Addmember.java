package com.example.clubolympus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_member_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.save_member:
                return true;
            case R.id.delete_member:
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

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

         genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 String selectedGender = (String) parent.getItemAtPosition(position);
                 if (!TextUtils.isEmpty((selectedGender))){
                     if (selectedGender.equals("Male")){
                         gender =1;
                     } else if (selectedGender.equals("Female")) {
                         gender =2;
                     } else {
                         gender =0;
                     }
                 }
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {
                 gender =0;
             }
         });
         



    }
}
