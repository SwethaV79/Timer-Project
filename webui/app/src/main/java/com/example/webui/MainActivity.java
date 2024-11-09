package com.example.webui; // Change to your package name

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewOrderAgain, recyclerViewPastOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewOrderAgain = findViewById(R.id.recyclerViewOrderAgain);
        recyclerViewPastOrders = findViewById(R.id.recyclerViewPastOrders);

        // Set layout managers
        recyclerViewOrderAgain.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerViewPastOrders.setLayoutManager(new GridLayoutManager(this, 3));

        // Set adapters
        recyclerViewOrderAgain.setAdapter(new ProductAdapter(getOrderAgainProducts()));
        recyclerViewPastOrders.setAdapter(new ProductAdapter(getPastOrderProducts()));
    }

    private Product[] getOrderAgainProducts() {
        return new Product[]{
                new Product("Toys", R.drawable.ic_toys),
                new Product("Phones", R.drawable.ic_phones),
                new Product("Scissors", R.drawable.ic_scissors),
        };
    }

    private Product[] getPastOrderProducts() {
        return new Product[]{
                new Product("Toys", R.drawable.ic_toys),
                new Product("Phones", R.drawable.ic_phones),
                new Product("Scissors", R.drawable.ic_scissors),
        };
    }
}
