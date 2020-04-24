package com.example.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PizzaMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_main);
        ArrayList<RecyclerViewItem> arrayList;
        arrayList = new ArrayList<RecyclerViewItem>();
        arrayList.add(new RecyclerViewItem(R.drawable.marghuerita_1, R.drawable.ic_timer_24dp,
                Utils.RECIPE_TITLE_1, Utils.RECIPE_TIME_1,Utils.RECIPE_SHORT_1, Utils.RECIPE_FULL_1));
        arrayList.add(new RecyclerViewItem(R.drawable.margarita_2, R.drawable.ic_timer_24dp,
                Utils.RECIPE_TITLE_2,Utils.RECIPE_TIME_2,Utils.RECIPE_SHORT_2,Utils.RECIPE_FULL_2));
        arrayList.add(new RecyclerViewItem(R.drawable.goats_cheese_pizza_3, R.drawable.ic_timer_24dp,
                Utils.RECIPE_TITLE_3,Utils.RECIPE_TIME_3,Utils.RECIPE_SHORT_3,Utils.RECIPE_FULL_3));
        arrayList.add(new RecyclerViewItem(R.drawable.healhy_pizza_4, R.drawable.ic_timer_24dp,
                Utils.RECIPE_TITLE_4, Utils.RECIPE_TIME_4,Utils.RECIPE_SHORT_4,Utils.RECIPE_FULL_4 ));
        arrayList.add(new RecyclerViewItem(R.drawable.pan_pizza_5, R.drawable.ic_timer_24dp,
                Utils.RECIPE_TITLE_5, Utils.RECIPE_TIME_5,Utils.RECIPE_SHORT_5, Utils.RECIPE_FULL_5));
        arrayList.add(new RecyclerViewItem(R.drawable.sourdough_pizzar_6, R.drawable.ic_timer_24dp,
                Utils.RECIPE_TITLE_6,Utils.RECIPE_TIME_6,Utils.RECIPE_SHORT_6, Utils.RECIPE_FULL_6 ));
        arrayList.add(new RecyclerViewItem(R.drawable.chicken_tikka_masala_7, R.drawable.ic_timer_24dp,
                Utils.RECIPE_TITLE_7,Utils.RECIPE_TIME_7,
                Utils.RECIPE_SHORT_7, Utils.RECIPE_FULL_7 ));



        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerViewAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }


}
