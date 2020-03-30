package com.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    String[] addresses ={"mosandr5@gmail.com"};
    String subject = "Order from MusicShop";
    String emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle("Your Order");
        Intent recivedIntent = getIntent();
        String userName = recivedIntent.getStringExtra("userName");
        String goodsName = recivedIntent.getStringExtra("goodsName");
        int quantity = recivedIntent.getIntExtra("quantity", 0);
        double price = recivedIntent.getDoubleExtra("price", 0);
        double orderPrice = recivedIntent.getDoubleExtra("orderPrice", 0);

        TextView orderTextView = findViewById(R.id.orderTextView);
        emailText = "Customer name: "+ userName+ "\nGoods Name: "
                + goodsName + "\nQuantity: "+ quantity +"\nPrice: "+price +"\nOrder Price: "+orderPrice;
        orderTextView.setText(emailText);
    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
