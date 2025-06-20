package com.pluralsight.NorthwindTradersAPI.Dao;

import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAll();
    Product productGetById(int id);
    Product addProduct(Product product);
    void update(int id, Product product);
    void Delete(int id);
}
