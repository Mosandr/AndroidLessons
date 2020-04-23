package com.example.pizzarecipes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private ArrayList<RecyclerViewItem> arrayList;
    private OnItemClickListener onItemClickListener;

    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> arrayList, OnItemClickListener onItemClickListener){
        this.arrayList=arrayList;
        this.onItemClickListener = onItemClickListener;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        ImageView imageView2;
        TextView textViewTitle;
        TextView textViewTime;
        TextView textViewShortRecipe;
        OnItemClickListener onItemClickListener;

        public RecyclerViewHolder(@NonNull View itemView,OnItemClickListener onItemClickListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageMain);
            imageView2 = itemView.findViewById(R.id.imageViewTime);
            textViewTitle =itemView.findViewById(R.id.textViewTitle);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            textViewShortRecipe = itemView.findViewById(R.id.textViewShortRecipe);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycle_view_item,parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view, onItemClickListener);
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

    public interface OnItemClickListener{
        void onItemClick(int position);
    }






}
