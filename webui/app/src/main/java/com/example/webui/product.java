package com.example.webui; // Change to your package name

public class Product {
    private String name;
    private int imageResId;

    public Product(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
