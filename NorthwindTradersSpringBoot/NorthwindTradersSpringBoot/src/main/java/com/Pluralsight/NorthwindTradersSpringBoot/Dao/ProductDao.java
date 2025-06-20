package com.Pluralsight.NorthwindTradersSpringBoot.Dao;

import com.Pluralsight.NorthwindTradersSpringBoot.model.Product;


import java.util.ArrayList;
import java.util.List;


public class ProductDao implements IProductDao{
    private int nextId = 3;

    final private List<Product> products = new ArrayList<>();

    public ProductDao() {
        products.add(new Product(1, "Laptop", 1, 799));
        products.add(new Product(2, "Desk Chair", 2, 149));
    }


    @Override
    public void add(Product product) {
        Product newproduct = new Product(nextId++, product.getName(), product.getCategory(), product.getPrice());
        products.add(newproduct);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
