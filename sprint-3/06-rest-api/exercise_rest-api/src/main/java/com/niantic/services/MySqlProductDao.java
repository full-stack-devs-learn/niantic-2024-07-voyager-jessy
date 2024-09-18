package com.niantic.services;

import com.niantic.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductDao implements ProductDao{
    JdbcTemplate jdbcTemplate;

    public MySqlProductDao() {
        String databaseUrl = "jdbc:mysql://localhost:3306/northwind";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource(){{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) {
        List<Product> products = new ArrayList<>();

        String sql = """
                SELECT product_id
                	, product_name
                    , supplier_id
                    , category_id
                    , quantity_per_unit
                    , unit_price
                    , units_in_stock
                    , units_on_order
                	, reorder_level
                FROM products
                WHERE category_id = ?
                ORDER BY category_id
                    , product_name;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, categoryId);

        while(row.next())
        {
            int productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            int supplierId = row.getInt("supplier_id");
            String quantityPerUnit = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");

            var product = new Product(productId,productName,supplierId,categoryId,quantityPerUnit,unitPrice,unitsInStock,unitsOnOrder,reorderLevel);
            products.add(product);
        }
        return products;
    }
}
