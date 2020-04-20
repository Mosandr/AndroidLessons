package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter <RecycleViewAdapter.RecyclerViewViewHolder> {

    private ArrayList<RecycleViewItem> arrayList;

    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView1;
        TextView textView2;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }

    public RecycleViewAdapter(ArrayList<RecycleViewItem> arrayList) {
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item,
                parent, false);
        RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(view);
        return recyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {
        RecycleViewItem recycleViewItem=arrayList.get(position);
        holder.imageView.setImageResource(recycleViewItem.getImageRecource());
        holder.textView1.setText(recycleViewItem.getText1());
        holder.textView2.setText(recycleViewItem.getText2());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
