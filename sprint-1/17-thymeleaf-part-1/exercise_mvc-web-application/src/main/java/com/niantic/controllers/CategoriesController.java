package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


import javax.swing.*;
import java.util.ArrayList;

@Controller
public class CategoriesController {
    private CategoryDao categoryDao = new CategoryDao();

    // http://localhost:8080/categories
    @GetMapping("/categories")
    public String getAllCategories(Model model)
    {
        ArrayList<Category> categories = categoryDao.getCategories();
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

    @GetMapping("/categories/add")
    public String addCategory(Model model) // this will show the form, but doesn't process. It will also add potentially personal information itno the url!
    {
        model.addAttribute("category", new Category());
        model.addAttribute("action", "add");

        return "categories/add_edit";
    }

    @PostMapping("/categories/add")
    public String addCategory(@ModelAttribute("category") Category category)
    {
        categoryDao.addCategory(category);
//        model.addAttribute("category", category); add Model model if you need this
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/edit")
    public String editCategory(Model model, @PathVariable int id)
    {
        Category category = categoryDao.getCategoryById(id);
        model.addAttribute("category", category);
        model.addAttribute("action", "edit");
        return "categories/add_edit";
    }

    @PostMapping("/categories/{id}/edit")
    public String editCategory(@ModelAttribute("category") Category category, @PathVariable int id)
    {
        category.setCategoryId(id);
        categoryDao.updateCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/delete")
    public String deleteCategory(Model model, @PathVariable int id)
    {
        Category category = categoryDao.getCategoryById(id);
        model.addAttribute("category", category);
        model.addAttribute("action", "delete");
        return "categories/delete";
    }

    @PostMapping("/categories/{id}/delete")
    public String deleteCategory(@PathVariable int id)
    {
        categoryDao.deleteCategory(id);
        return "redirect:/categories";
    }


}
