package com.Pluralsight.NorthwindTradersSpringBoot.Dao;

import com.Pluralsight.NorthwindTradersSpringBoot.model.Product;

import java.util.List;

public interface IProductDao {
    void add(Product product);

    List<Product> getAll();

}

