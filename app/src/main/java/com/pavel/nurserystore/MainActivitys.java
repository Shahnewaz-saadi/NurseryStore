package com.pavel.nurserystore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

    public class MainActivitys extends AppCompatActivity {
        private static List<CartItem> cartItems = new ArrayList<>();
        private RecyclerView recyclerView;
        private CartItemAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            recyclerView = findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            adapter = new CartItemAdapter();
            recyclerView.setAdapter(adapter);

            // Example code to add items to the cart (you can replace it with your logic)
            String itemName = "Example Item";
            double itemPrice = 9.99;
            int itemQuantity = 1;
            addItemToCart(itemName, itemPrice, itemQuantity);
        }

        private void addItemToCart(String name, double price, int quantity) {
            CartItem item = new CartItem(name, price, quantity);
            cartItems.add(item);
            adapter.notifyDataSetChanged();
        }

        private static class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> {

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_row, parent, false);
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                CartItem item = cartItems.get(position);

                holder.itemNameTextView.setText(item.getName());
                holder.itemPriceTextView.setText(String.valueOf(item.getPrice()));
                holder.itemQuantityTextView.setText(String.valueOf(item.getQuantity()));
            }

            @Override
            public int getItemCount() {
                return cartItems.size();
            }

            static class ViewHolder extends RecyclerView.ViewHolder {
                TextView itemNameTextView;
                TextView itemPriceTextView;
                TextView itemQuantityTextView;

                ViewHolder(View itemView) {
                    super(itemView);
                    itemNameTextView = itemView.findViewById(R.id.item_name_text_view);
                    itemPriceTextView = itemView.findViewById(R.id.item_price_text_view);
                    itemQuantityTextView = itemView.findViewById(R.id.item_quantity_text_view);
                }
            }
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

            public String getName() {
                return name;
            }

            public double getPrice() {
                return price;
            }

            public int getQuantity() {
                return quantity;
            }
        }
    }
