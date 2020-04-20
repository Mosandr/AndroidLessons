package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<RecycleViewItem> recycleViewItemArrayList = new ArrayList<RecycleViewItem>();
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_mood_black_24dp, "Happy!", "Life is good!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_mood_bad_black_24dp, "Sad!", "Life is sad!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Neutral!", "Life is life!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_mood_black_24dp, "Happy!", "Life is good!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_mood_bad_black_24dp, "Sad!", "Life is sad!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Neutral!", "Life is life!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_mood_black_24dp, "Happy!", "Life is good!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_mood_bad_black_24dp, "Sad!", "Life is sad!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Neutral!", "Life is life!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_mood_black_24dp, "Happy!", "Life is good!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_mood_bad_black_24dp, "Sad!", "Life is sad!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Neutral!", "Life is life!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_mood_black_24dp, "Happy!", "Life is good!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_mood_bad_black_24dp, "Sad!", "Life is sad!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Neutral!", "Life is life!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_mood_black_24dp, "Happy!", "Life is good!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_mood_bad_black_24dp, "Sad!", "Life is sad!" ));
        recycleViewItemArrayList.add(
                new RecycleViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Neutral!", "Life is life!" ));

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        adapter = new RecycleViewAdapter(recycleViewItemArrayList);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }
}
