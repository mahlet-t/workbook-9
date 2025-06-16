package com.Pluralsight.NorthwindTradersSpringBoot.Dao;

import com.Pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {
    private int nextId = 3;

    final private List<Product> products = new ArrayList<>();

    public SimpleProductDao() {
        products.add(new Product(1, "Laptop", "Electronics", 799));
        products.add(new Product(2, "Desk Chair", "Furniture", 149));
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
