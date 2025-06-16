package com.Pluralsight.NorthwindTradersSpringBoot.model;

public class Product {
    final private int productId;
    final private String name;
    final private String category;
    final private double price;

    public Product(int productId, String name, String category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;

    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }


}
