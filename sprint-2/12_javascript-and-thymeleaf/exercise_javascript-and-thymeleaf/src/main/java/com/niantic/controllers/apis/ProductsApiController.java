package com.niantic.controllers.apis;

import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductsApiController {

    private ProductDao productDao = new ProductDao();

    @GetMapping("/api/products/pages")
    public int getProductCountPerCategory(int catId)
    {
        int totalCount = productDao.getProductCount(catId);
        int pages = totalCount/ 10;
        if(totalCount % 10 >0){
            pages++;
        };

        return pages;

    }



}
