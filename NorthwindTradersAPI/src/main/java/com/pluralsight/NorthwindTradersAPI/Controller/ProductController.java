package com.pluralsight.NorthwindTradersAPI.Controller;

import com.pluralsight.NorthwindTradersAPI.Dao.ProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ProductController {
    final private ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productDao.getAll();
    }

    @GetMapping(path = "/products/{id}")
    public Product getProductsById(@PathVariable int id) {
        return productDao.productGetById(id);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productDao.addProduct(product);
    }
    @PutMapping("/product/{id}")
    public void update(@PathVariable int id,@RequestBody Product product){
        productDao.update(id,product);
    }
    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable int id){
        productDao.Delete(id);
    }

}
