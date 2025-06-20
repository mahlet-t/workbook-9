package com.pluralsight.NorthwindTradersAPI.Controller;

import com.pluralsight.NorthwindTradersAPI.Dao.ProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ProductController {
   final private ProductDao productDao;

    public ProductController(ProductDao productDao) {
     this.productDao=productDao;
    }
@GetMapping("/products")
    public List<Product> getAllProduct() {
        return productDao.getAll();
    }
    @GetMapping(path = "/products/{id}")
    public Product getProductsById(@PathVariable int id){
       return productDao.productGetById(id);



    }

}
