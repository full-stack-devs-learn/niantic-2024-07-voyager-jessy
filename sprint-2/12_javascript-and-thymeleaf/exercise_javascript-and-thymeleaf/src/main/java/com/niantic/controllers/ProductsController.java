package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import org.springframework.validation.BindingResult;



import java.util.ArrayList;

@Controller
public class ProductsController
{
    private CategoryDao categoryDao = new CategoryDao();
    private ProductDao productDao = new ProductDao();

    // list all categories
    @GetMapping( "/products")
    public String products(Model model, @RequestParam(defaultValue = "1") Integer catId)
    {
        var category = categoryDao.getCategoryById(catId);
        var categories = categoryDao.getCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("currentCategory", category);

        return "products/index";
    }

    //added 9.4
    @GetMapping ("/products/category/{catId}")
    public String productsByCategory(Model model, @PathVariable int catId){

        var products= productDao.getProductsByCategory(catId);

        model.addAttribute("products", products);


        return "products/fragments/product-list-table";

    }

    @GetMapping("products/category/{categoryId}/page/{page}")
    public String getAllProducts(Model model,@PathVariable int categoryId, @PathVariable int page)
    {
        var products = productDao.getProducts(categoryId, page);


        model.addAttribute("products", products);
        return "products/fragments/product-list-table";


    }

    //im not sure exactly what this does but it was the only way to not get an error when trying to
    //display the link to find out how many pages each categoryid should contain
    @GetMapping("products/category/{categoryId}/pages")
    public ResponseEntity<Integer> getProductPageCount(@PathVariable Integer categoryId)
    {
        int total = productDao.getProductCount(categoryId);
        int pages = total/ 10;
        if(total % 10 >0) pages++;

        return ResponseEntity.ok(pages);
        //after reading: this provides clear structure and control over response and handles edge cases and
        //helps with api
    }


    @GetMapping("/products/{id}")
    public String getProduct(Model model, @PathVariable int id)
    {
        var product = productDao.getProduct(id);

        if(product == null)
        {
            return "404";
        }

        var category = categoryDao.getCategoryById(product.getCategoryId());

        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "products/details";
    }

    // add category
    @GetMapping("/products/new")
    public String addCategory(Model model)
    {
        var categories = categoryDao.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new Product());
        return "products/add";
    }

    @PostMapping("/products/new")
    public String saveProduct( Model model, @Valid @ModelAttribute("product") Product product, BindingResult result)
    {
        if(result.hasErrors())
        {
            var categories = categoryDao.getCategories();
            model.addAttribute("categories", categories);
            model.addAttribute("product", product);
            model.addAttribute("isInvalid", true);
            return "products/add";
        }

        productDao.addProduct(product);
        return "redirect:/products?catId=" + product.getCategoryId();
    }

    // edit category
    @GetMapping("/products/{id}/edit")
    public String editProduct(Model model, @PathVariable int id)
    {
        var product = productDao.getProduct(id);

        if(product == null)
        {
            return "404";
        }

        var categories = categoryDao.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping("/products/{id}/edit")
    public String editCategory(@ModelAttribute("product") Product product, @PathVariable int id)
    {
        productDao.updateProduct(product);

        return "redirect:/products?catId=" + product.getCategoryId();
    }


    // edit category
    @GetMapping("/products/{id}/delete")
    public String deleteCategory(Model model, @PathVariable int id)
    {
        var product = productDao.getProduct(id);

        if(product == null)
        {
            return "404";
        }

        var category = categoryDao.getCategoryById(product.getCategoryId());
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "products/delete";
    }

    @PostMapping("/products/{id}/delete")
    public String deleteCategoryConfirm(@PathVariable int id)
    {
        var product = productDao.getProduct(id);
        if(product == null)
        {
            return "404";
        }

        productDao.deleteProduct(id);

        return "redirect:/products?catId=" + product.getCategoryId();
    }
}
