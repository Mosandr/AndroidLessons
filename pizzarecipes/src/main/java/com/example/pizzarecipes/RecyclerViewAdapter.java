package com.example.pizzarecipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    ArrayList<RecyclerViewItem> arrayList;
    Context context;

    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> arrayList, Context context){
        this.arrayList=arrayList;
        this.context=context;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;
        public ImageView imageView2;
        public TextView textViewTitle;
        public TextView textViewTime;
        public TextView textViewShortRecipe;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            imageView = itemView.findViewById(R.id.imageMain);
            imageView2 = itemView.findViewById(R.id.imageViewTime);
            textViewTitle =itemView.findViewById(R.id.textViewTitle);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            textViewShortRecipe = itemView.findViewById(R.id.textViewShortRecipe);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            RecyclerViewItem recyclerViewItem = arrayList.get(position);

            Intent intent = new Intent(context, PizzaRecipeActivity.class);
            intent.putExtra("imageMain", recyclerViewItem.getMainImageResource());
            intent.putExtra("imageTime", recyclerViewItem.getTimeImageResource());
            intent.putExtra("textTitle", recyclerViewItem.getTitleText());
            intent.putExtra("textTime", recyclerViewItem.getTimeText());
            intent.putExtra("textRecipe", recyclerViewItem.getRecipeFullText());
            context.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycle_view_item,parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        RecyclerViewItem recyclerViewItem = arrayList.get(position);
        holder.imageView.setImageResource(recyclerViewItem.getMainImageResource());
        holder.imageView2.setImageResource(recyclerViewItem.getTimeImageResource());
        holder.textViewTitle.setText(recyclerViewItem.getTitleText());
        holder.textViewTime.setText(recyclerViewItem.getTimeText());
        holder.textViewShortRecipe.setText(recyclerViewItem.getRecipeShortText());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
