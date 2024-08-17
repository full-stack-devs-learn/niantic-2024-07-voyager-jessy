//package com.niantic.controllers;
//
//import com.niantic.models.Product;
//import com.niantic.services.ProductDao;
//import com.niantic.models.Category;
//import com.niantic.services.CategoryDao;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//
//
////@Controller
//public class ProductsController {
//
//    private ProductDao productDao = new ProductDao();
//    private CategoryDao categoryDao = new CategoryDao();
//
//
////        use http:localhost:8080/products
//
//    @GetMapping("/products/{id}")
//    public String getProductsByCategory(Model model, @PathVariable int id) {
//        ArrayList<Category> categories = categoryDao.getCategories();
//        ArrayList<Product> products = productDao.getProductsByCategory(id);
//
//        model.addAttribute("products", products);
//        model.addAttribute("categories", categories);
//
//        return "/products/index";
//    }
//
//
//}