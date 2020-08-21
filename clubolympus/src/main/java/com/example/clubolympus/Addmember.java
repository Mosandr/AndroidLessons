package com.example.clubolympus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.clubolympus.data.ClubOlympusContract.MemberEntry;


public class Addmember extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<Cursor>   {

    private EditText nameEditText;
    private EditText surnameEditText;
    private EditText sportEditText;
    private Spinner genderSpinner;
    private int gender = 0;
    private ArrayAdapter<CharSequence> spinnerAdapter;
    public static final int EDIT_MEMBER_LOADER = 111;
    private Uri currentMemberUri;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_member_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.save_member:
                saveMember();
                return true;
            case R.id.delete_member:
                showDeleteDialog();
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDeleteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want delete the member&");
        builder.setPositiveButton("Delete",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteMember();    
                    }
                });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              if (dialog != null){
                  dialog.dismiss();
              }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void deleteMember() {
        if (currentMemberUri !=null){
            int rowsDeleted = getContentResolver().delete(
                    currentMemberUri, null,null);

            if (rowsDeleted == 0){
                Toast.makeText(this, "Deleting failed",Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Deleting successfully",Toast.LENGTH_LONG).show();
            }

            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmember);

        Intent intent = getIntent();
        currentMemberUri = intent.getData();


        if(currentMemberUri==null){
            setTitle("Add a member");
            invalidateOptionsMenu();
        } else{
            setTitle("Edit the Member");
            getSupportLoaderManager().initLoader(EDIT_MEMBER_LOADER,null,this);
        }

        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        sportEditText = findViewById(R.id.groupEditText);
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
                         gender = MemberEntry.GENDER_MALE;
                     } else if (selectedGender.equals("Female")) {
                         gender = MemberEntry.GENDER_FEMALE;
                     } else {
                         gender = MemberEntry.GENDER_UNKNOWN;
                     }
                 }
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {
                 gender =0;
             }
         });

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (currentMemberUri == null){
            MenuItem menuItem = menu.findItem(R.id.delete_member);
            menuItem.setVisible(false);
        }
        return  true;
    }

    private void saveMember(){
        String firstName = nameEditText.getText().toString().trim();
        String lastName = surnameEditText.getText().toString().trim();
        String sport = sportEditText.getText().toString().trim();

        if (TextUtils.isEmpty(firstName)){
            Toast.makeText(this, "Input the first name",
                    Toast.LENGTH_LONG).show();
            return;
        } else if (TextUtils.isEmpty(lastName)){
            Toast.makeText(this, "Input the last name",
                    Toast.LENGTH_LONG).show();
            return;
        } else if(TextUtils.isEmpty(sport)){
            Toast.makeText(this, "Input the sport",
                    Toast.LENGTH_LONG).show();
            return;
        } else if (gender == MemberEntry.GENDER_UNKNOWN){
            Toast.makeText(this, "Choose the gender",
                    Toast.LENGTH_LONG).show();
            return;
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(MemberEntry.KEY_FIRST_NAME,firstName);
        contentValues.put(MemberEntry.KEY_LAST_NAME,lastName);
        contentValues.put(MemberEntry.KEY_SPORT,sport);
        contentValues.put(MemberEntry.KEY_GENDER,gender);

        if(currentMemberUri==null){

            ContentResolver contentResolver = getContentResolver();
            Uri uri = contentResolver.insert(MemberEntry.CONTENT_URI, contentValues);

            if(uri==null){
                Toast.makeText(this, "Insertion of data in table failed",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Data saved",
                        Toast.LENGTH_LONG).show();
            }
        } else {
           int rowsChanged =  getContentResolver().update(
                   currentMemberUri, contentValues, null,null);
           if (rowsChanged==0){
               Toast.makeText(this, "Saving of data in table failed",
                       Toast.LENGTH_LONG).show();
           } else {
               Toast.makeText(this, "Member updated successfully",
                       Toast.LENGTH_LONG).show();
           }
        }
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        String [] projection = {
                MemberEntry._ID,
                MemberEntry.KEY_FIRST_NAME,
                MemberEntry.KEY_LAST_NAME,
                MemberEntry.KEY_GENDER,
                MemberEntry.KEY_SPORT
        };
        return new CursorLoader(this, currentMemberUri,
                projection,null,null, null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        if(data.moveToFirst()){
            int firstNameIndex = data.getColumnIndex(MemberEntry.KEY_FIRST_NAME);
            int lastNameIndex = data.getColumnIndex(MemberEntry.KEY_LAST_NAME);
            int genderIndex = data.getColumnIndex(MemberEntry.KEY_GENDER);
            int sportIndex = data.getColumnIndex(MemberEntry.KEY_SPORT);

            String firstName =data.getString(firstNameIndex);
            String lastName =data.getString(lastNameIndex);
            int gender =data.getInt(genderIndex);
            String sport =data.getString(sportIndex);

            nameEditText.setText(firstName);
            surnameEditText.setText(lastName);
            sportEditText.setText(sport);

            switch (gender){
                case MemberEntry.GENDER_MALE:
                    genderSpinner.setSelection(1);
                    break;
                case MemberEntry.GENDER_FEMALE:
                    genderSpinner.setSelection(2);
                    break;
                case MemberEntry.GENDER_UNKNOWN:
                    genderSpinner.setSelection(0);
                    break;
            }

        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
