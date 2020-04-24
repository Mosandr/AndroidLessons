package com.example.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_recipe);

        ImageView imageViewMain =findViewById(R.id.imageViewMain);
        ImageView imageViewTime =findViewById(R.id.imageViewTime);
        TextView textViewTime  = findViewById(R.id.textViewTime);
        TextView textViewRecipe =findViewById(R.id.textViewShortRecipe);

        Intent intent = getIntent();
        if (intent!=null){
            setTitle(intent.getStringExtra("textTitle"));
            int imId = intent.getIntExtra("imageMain",0);
            int imid2 = intent.getIntExtra("imageTime",0);
            if(imId!=0&imid2!=0)
            {
            imageViewMain.setImageResource(imId);
            imageViewTime.setImageResource(imid2);
            }
            textViewTime.setText(intent.getStringExtra("textTime"));
            textViewRecipe.setText(intent.getStringExtra("textRecipe"));
        }

    }
}
