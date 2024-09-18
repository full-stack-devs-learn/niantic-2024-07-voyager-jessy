package com.niantic.services;

import com.niantic.models.Product;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface ProductDao
{
List<Product> getProductsByCategory(int categoryId);
}
