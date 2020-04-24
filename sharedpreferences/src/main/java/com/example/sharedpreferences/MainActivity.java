package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences( "mySharedPreferences",
                Context.MODE_PRIVATE); // visible for all app
        //SharedPreferences sharedPreferences1 = this.getPreferences(MODE_PRIVATE);
        //visible only for this activity

        SharedPreferences.Editor editor =sharedPreferences.edit();
//        editor.putString("newHelloText", "Hello Shared Prefernces!");
//
        editor.clear();
        editor.apply();
        //clear data from preferences

        TextView textView= findViewById(R.id.textView1);
        textView.setText(sharedPreferences.getString("newHelloText","Default text"));

    }
}
