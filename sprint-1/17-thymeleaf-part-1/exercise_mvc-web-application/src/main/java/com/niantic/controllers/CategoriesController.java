package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;


import javax.swing.*;
import java.util.ArrayList;

@Controller
public class CategoriesController
{
    private CategoryDao categoryDao = new CategoryDao();

    @getMapping("/category")

    public String getCategory(Model model)
    {
        ArrayList< Category> categories =categoryDao.getCategories();
       model.addAttribute("category", categories);

    }
}
