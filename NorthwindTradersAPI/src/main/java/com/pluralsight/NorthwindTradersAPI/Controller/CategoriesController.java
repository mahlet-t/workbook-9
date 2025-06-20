package com.pluralsight.NorthwindTradersAPI.Controller;

import com.pluralsight.NorthwindTradersAPI.Dao.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class CategoriesController {

    final private CategoryDao categoryDao;

    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/category")
    public List<Category> getAllCategory() {

        return categoryDao.getAll();
    }

    @GetMapping(path = "/category/{id}")
    public Category getCategoryByID(@PathVariable int id) {
        return categoryDao.categoryGetById(id);
    }

    @PostMapping(path = "/category")

    public Category add(@RequestBody Category category) {
        return categoryDao.add(category);
    }

    @PutMapping("/category/{id}")
    public void update(@PathVariable int id, @RequestBody Category category) {
        categoryDao.update(id, category);
    }
    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable int id){
        categoryDao.delete(id);
    }
}
