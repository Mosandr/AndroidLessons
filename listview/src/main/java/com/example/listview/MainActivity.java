package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        final ArrayList<String> arrayListView = new ArrayList<>();
        arrayListView.add("Красный");
        arrayListView.add("Оранжевый");
        arrayListView.add("Желтый");
        arrayListView.add("Зеленый");
        arrayListView.add("Голубой");
        arrayListView.add("Синий");
        arrayListView.add("Фиолетовый");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,arrayListView);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tostText = arrayListView.get(position);
                Toast.makeText(MainActivity.this, tostText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

