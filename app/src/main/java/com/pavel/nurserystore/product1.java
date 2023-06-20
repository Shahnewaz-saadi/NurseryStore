package com.pavel.nurserystore;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class product1 extends AppCompatActivity {

    public final List<CartItem> cartItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product1);

        Button addtocart = findViewById(R.id.addtocart);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = "Item: ";
                double itemPrice = 99.99;
                int itemQuantity = 1;

                // Create a new CartItem object
                CartItem item = new CartItem(itemName, itemPrice, itemQuantity);

                // Add the item to the cart
                addItemToCart(item);

                // Show a toast message indicating successful addition to the cart
                Toast.makeText(product1.this, "Item added to cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addItemToCart(CartItem item) {
        // Add the item to the cart
        cartItems.add(item);

        // Optionally, update the UI to reflect the added item
        // ...
    }

    static class CartItem {
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
