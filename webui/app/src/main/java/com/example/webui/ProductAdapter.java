package com.example.webui; // Change to your package name

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Product[] products;

    public ProductAdapter(Product[] products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products[position];
        holder.productName.setText(product.getName());
        holder.productImage.setImageResource(product.getImageResId());
    }

    @Override
    public int getItemCount() {
        return products.length;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        ImageView productImage;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productImage = itemView.findViewById(R.id.productImage);
        }
    }
}
