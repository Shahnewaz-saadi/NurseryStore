package com.pavel.nurserystore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    public final List<product1.CartItem> cartItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Button addtocart = findViewById(R.id.addtocart);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = "Example Item";
                double itemPrice = 9.99;
                int itemQuantity = 1;

                // Create a new CartItem object
                com.pavel.nurserystore.product1.CartItem item = new com.pavel.nurserystore.product1.CartItem(itemName, itemPrice, itemQuantity);

                // Add the item to the cart
                addItemToCart(item);

                // Show a toast message indicating successful addition to the cart
                Toast.makeText(com.pavel.nurserystore.MainActivity5.this, "Item added to cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addItemToCart(com.pavel.nurserystore.product1.CartItem item) {
        // Add the item to the cart
        cartItems.add(item);

        // Optionally, update the UI to reflect the added item
        // ...
    }

    private static class CartItem {
        private String name;
        private double price;
        private int quantity;

        public CartItem(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }
}