package com.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MusicShopActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quantity = 0;
    ArrayList spinnerArray;
    Spinner spinner;
    ArrayAdapter spinnerAdapter;
    HashMap goodsMap;
    String goodsName;
    double price;
    EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_shop);
        createSpinner();
        createHashMap();
        userNameEditText = findViewById(R.id.editText);

    }

    public void createSpinner(){
        spinnerArray = new ArrayList();
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArray.add("guitar");
        spinnerArray.add("piano");
        spinnerArray.add("drums");
        spinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerArray);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerAdapter);
    }

    public void createHashMap(){
        goodsMap= new HashMap();
        goodsMap.put("guitar",200.0);
        goodsMap.put("piano",500.0);
        goodsMap.put("drums",1000.0);
    }

    public void increaseQuantity(View view) {
        TextView quantityTextView = findViewById(R.id.textViewNumberQuantity);
        quantity++;
        quantityTextView.setText(""+quantity);
        TextView priceTextView = findViewById(R.id.textViewPrice);
        priceTextView.setText(""+price*quantity);
    }


    public void decreaseQuantity(View view) {
        TextView quantityTextView = findViewById(R.id.textViewNumberQuantity);
        if (quantity!=0) {
        quantity--;}
        quantityTextView.setText(""+quantity);
        TextView priceTextView = findViewById(R.id.textViewPrice);
        priceTextView.setText(""+price*quantity);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
        quantity=1;
        TextView quantityText = findViewById(R.id.textViewNumberQuantity);
        quantityText.setText(""+quantity);
        TextView priceTextView = findViewById(R.id.textViewPrice);
        priceTextView.setText(""+price*quantity);
        ImageView goodsImage = findViewById(R.id.imageViewGoods);

        switch (goodsName) {
            case "guitar":
                goodsImage.setImageResource(R.drawable.guitar);
                break;
            case "piano":
                goodsImage.setImageResource(R.drawable.piano);
                break;
            case "drums":
                goodsImage.setImageResource(R.drawable.drums);
                break;
            default:
                goodsImage.setImageResource(R.drawable.guitar);
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addToCart(View view) {
        Order order = new Order();
        order.userName = userNameEditText.getText().toString();
        order.goodsName = goodsName;
        order.quantity = quantity;
        order.orderPrice = quantity*price;
//
//        Log.d("userName",order.userName);
//        Log.d("goodsName",order.goodsName);
//        Log.d("quantity",""+order.quantity);
//        Log.d("orderPrice",""+ order.orderPrice);

        Intent intentOrder = new Intent(MusicShopActivity.this,OrderActivity.class);

         intentOrder.putExtra("userName",order.userName);
         intentOrder.putExtra("goodsName",goodsName);
         intentOrder.putExtra("quantity",quantity);
         intentOrder.putExtra("price",price);
         intentOrder.putExtra("orderPrice",order.orderPrice);
         startActivity(intentOrder);

    }
}
