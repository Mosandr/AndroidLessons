package com.example.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaRecipeActivity extends AppCompatActivity {
    private ImageView imageViewMain;
    private ImageView imageViewTime;
    private TextView textViewTime;
    private TextView textViewRecipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_recipe);
        Intent intent = getIntent();
//        imageViewMain =findViewById(R.id.imageMain);
//        imageViewTime =findViewById(R.id.imageViewTime);
//        textViewTime  = findViewById(R.id.textViewTime);
        textViewRecipe =findViewById(R.id.textViewShortRecipe);
        setTitle(intent.getStringExtra("textTitle"));
//        imageViewMain.setImageResource(intent.getIntExtra("imageMAin",0));
//        imageViewMain.setImageResource(intent.getIntExtra("imageTime",0));
//        textViewTime.setText(intent.getStringExtra("textTime"));
        textViewRecipe.setText(intent.getStringExtra("textRecipe"));


    }
}
