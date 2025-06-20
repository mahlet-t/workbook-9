package com.Pluralsight.NorthwindTradersSpringBoot.model;

public class Product {
    private int productId;
    private String name;
    private int category;
    private double price;

    public Product() {
    }

    public Product(int productId, String name, int category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;

    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }


}
