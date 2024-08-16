package com.niantic.controllers;

import com.niantic.models.Product;
import com.niantic.services.ProductDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;


//@Controller
public class ProductsController {}
//
//    private ProductDao productDao = new ProductDao();
//
////        use http:localhost:8080/products
//
//    @GetMapping("/products?catId=1")
//    public String getProductsByCategory(Model model, @PathVariable int id) {
//        var product = productDao.getProductsByCategory(id);
//        model.addAttribute("product", product);
//        model.addAttribute("category", product);
//
//        return "/products/index";
//    }
//}
//}
