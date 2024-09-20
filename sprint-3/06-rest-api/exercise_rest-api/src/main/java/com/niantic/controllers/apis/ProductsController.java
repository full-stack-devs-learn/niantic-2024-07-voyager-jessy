package com.niantic.controllers.apis;

import com.niantic.models.HttpError;
import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.MySqlProductDao;
import com.niantic.services.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private CategoryDao categoryDao;
    private ProductDao productDao;

    @Autowired
    public ProductsController(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }

//    private ProductDao productDao = new MySqlProductDao();

    @GetMapping("")
    public ResponseEntity<?> getProductsByCategory(@RequestParam int catId) {

        try
        {
            var products = productDao.getProductsByCategory(catId);
            var categories = categoryDao.getCategory(catId);
            if(categories == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(products);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProductByProductId(@PathVariable int id) {

        try
        {
            var product = productDao.getProductById(id);
            if (product == null)
            {
                var error = new HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Product " + id + " is invalid");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
            return ResponseEntity.ok(product);
        }
        catch(Exception e)
        {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Error has occurred");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {

        return productDao.addProduct(product);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        productDao.updateProduct(id, product);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id) {
        productDao.deleteProduct(id);

    }


}
