package com.example.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class PizzaMainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<RecyclerViewItem> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_main);

        arrayList = new ArrayList<RecyclerViewItem>();
        arrayList.add(new RecyclerViewItem(R.drawable.marghuerita_1, R.drawable.ic_timer_24dp,
                "Next level Margherita pizza","1 HOUR AND 40 MINS",
                "Forget takeaways – you can’t beat a homemade Margherita pizza topped " +
                "with fresh tomato sauce and melted...", "" +
                "1. First, make the dough. Tip the flour into a bowl and add 300ml tepid water. Mix together and set aside at room temperature for 1 hr. Dissolve the yeast in 2 tbsp water and mix this and 15g of salt through the dough. Cover with cling film and leave somewhere warm to double in size for a few hours. For a sourer flavour, leave in the fridge for at least 8 hrs and up to 24 hrs – the longer you leave it the sourer it will be.\n" +
                "\n" +
                "2. When the dough is ready, tip it onto a lightly floured surface and divide into four. Roll into balls and leave to rest, covered with a tea towel or cling film for another hour.\n" +
                "\n" +
                "3.Now make the tomato sauce. Drain some of the juice from the can and tip the rest into a bowl with the olive oil, oregano and a generous pinch of salt, then either scrunch everything together with your fingers for a chunky sauce or blitz with a stick blender if you want it smooth. Tie the basil stalks together, bruise with the back of a knife and place in the sauce. Leave the sauce at room temperature until needed.\n" +
                "\n" +
                "4. To make the pizza, heat a grill to its highest setting and get a heavy frying pan. On a floured surface push and stretch one of the balls of dough out into a circle roughly the same size as the frying pan. Slip the round onto a floured baking sheet and top with a quarter of the sauce, a scattering of cheese, a few basil leaves and a quarter of the mozzarella.\n" +
                "\n" +
                "5. Get the pan very hot and carefully slide the pizza onto it. Cook for 2 mins, then put the pan under the grill for another 2 mins until the sides are puffed up and the cheese has melted. Lift onto a board, drizzle with a little olive oil if you like, then cut into wedges and serve while you make the next one."
                ));
        arrayList.add(new RecyclerViewItem(R.drawable.margarita_2, R.drawable.ic_timer_24dp,
                "Pizza Margherita in 4 steps","35 MINS",
                "Even a novice cook can master the art of pizza " +
                        "with our simple step-by-step guide. Bellissimo","Recipe" ));
        arrayList.add(new RecyclerViewItem(R.drawable.goats_cheese_pizza_3, R.drawable.ic_timer_24dp,
                "Onion & goat's cheese pizza","50 MINS",
                "Make a veggie pizza that's healthy and low-fat instead of ordering a takeaway. " +
                        "This easy recipe uses goat's cheese...", "Recipe" ));
        arrayList.add(new RecyclerViewItem(R.drawable.healhy_pizza_4, R.drawable.ic_timer_24dp,
                "Superhealthy pizza","50 MINS",
                "The quantities for this are generous, so if you have any leftovers, " +
                        "pop a wedge of cold pizza into your lunchbox the next day", "Recipe" ));
        arrayList.add(new RecyclerViewItem(R.drawable.pan_pizza_5, R.drawable.ic_timer_24dp,
                "Frying pan pizza","45 MINS",
                "Not good for you? Think again, this easy " +
                        "to make pizza is low fat and full of calcium", "Recipe" ));
        arrayList.add(new RecyclerViewItem(R.drawable.sourdough_pizzar_6, R.drawable.ic_timer_24dp,
                "Sourdough pizza","2 HOURS",
                "Make homemade sourdough pizza with a wonderfully chewy crust. " +
                        "Try our margherita recipe, then customise...", "Recipe" ));
        arrayList.add(new RecyclerViewItem(R.drawable.chicken_tikka_masala_7, R.drawable.ic_timer_24dp,
                "Chicken tikka masala pizzas","20 MINS",
                "Rustle up our spiced chicken pizzas using naan bread in just 20 minutes. " +
                        "To balance the heat, serve them with...", "Recipe" ));



        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerViewAdapter(arrayList, this);
        recyclerView.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this,PizzaRecipeActivity.class);
        intent.putExtra("imageMAin", R.drawable.marghuerita_1);
        intent.putExtra("imageTime", arrayList.get(position).getTimeImageResource());
        intent.putExtra("textTitle", arrayList.get(position).getTitleText());
        intent.putExtra("textTime", arrayList.get(position).getTimeText());
        intent.putExtra("textRecipe", arrayList.get(position).getRecipeFullText());
        startActivity(intent);
    }
}
