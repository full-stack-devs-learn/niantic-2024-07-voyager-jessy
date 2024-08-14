package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import javax.swing.*;
import java.util.ArrayList;

@Controller
public class CategoriesController
{
    private CategoryDao categoryDao = new CategoryDao();

    // http://localhost:8080/category
    @GetMapping("/categories")
    public String getAllCategories(Model model)
    {
        ArrayList<Category> categories= categoryDao.getCategories();
        model.addAttribute("category", categories);
        return "categories/index";

    }
    @GetMapping("/categories/{id}")
    public String details(Model model, @PathVariable int id)
    {
        var category = categoryDao.getCategoryById(id);
        model.addAttribute("category", category);
        return "categories/details";
    }




}
