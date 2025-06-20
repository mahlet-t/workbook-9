package com.pluralsight.NorthwindTradersAPI.Controller;

import com.pluralsight.NorthwindTradersAPI.Dao.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@RestController
public class CategoriesController {

       final private CategoryDao categoryDao;

        public CategoriesController(CategoryDao categoryDao) {

            this.categoryDao=categoryDao;
        }
        @GetMapping("/category")
        public List<Category> getAllCategory() {

            return categoryDao.getAll();
        }
        @GetMapping(path = "/category/{id}")
        public Category getCategoryByID(@PathVariable int id){
            return categoryDao.categoryGetById(id);
        }
}
