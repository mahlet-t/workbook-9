package com.pluralsight.NorthwindTradersAPI.Dao;

import com.pluralsight.NorthwindTradersAPI.models.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getAll();
    Category categoryGetById(int id);
    Category add(Category category);
    void  update (int id, Category category);
    void delete(int id);
}
