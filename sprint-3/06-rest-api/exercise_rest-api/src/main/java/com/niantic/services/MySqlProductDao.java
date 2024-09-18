package com.niantic.services;

import com.niantic.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductDao implements ProductDao {
    JdbcTemplate jdbcTemplate;

    public MySqlProductDao() {
        String databaseUrl = "jdbc:mysql://localhost:3306/northwind";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource() {{
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

        while (row.next()) {
            int productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            int supplierId = row.getInt("supplier_id");
            String quantityPerUnit = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");

            var product = new Product(productId, productName, supplierId, categoryId, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product getProductById(int productId) {
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
                WHERE product_id = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, productId);
        if (row.next()) {
            String productName = row.getString("product_name");
            int supplierId = row.getInt("supplier_id");
            int categoryId = row.getInt("category_id");
            String quantityPerUnit = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");

            return new Product(productId, productName, supplierId, categoryId, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel);
        }
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        String sql = """
                INSERT INTO products (product_name
                				, supplier_id
                                , category_id
                                , quantity_per_unit
                                , unit_price
                                , units_in_stock
                                , units_on_order
                                , reorder_level)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                """;
        //inserts a new product and this keyholder will retrieve/retain the newly created id number
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getSupplierId());
            statement.setInt(3, product.getCategoryId());
            statement.setString(4, product.getQuantityPerUnit());
            statement.setDouble(5, product.getUnitPrice());
            statement.setInt(6, product.getUnitsInStock());
            statement.setInt(7, product.getUnitsOnOrder());
            statement.setInt(8, product.getReorderLevel());
            return statement;
        }, keyHolder);

        int newId = keyHolder.getKey().intValue();

        return getProductById(newId);
    }

    @Override
    public void updateProduct(int id, Product product) {

        String sql = """
                 UPDATE products
                 SET product_name = ?
                  		, supplier_id = ?
                  		, category_id = ?
                  		, quantity_per_unit = ?
                  		, unit_price = ?
                  		, units_in_stock = ?
                  		, units_on_order = ?
                  		, reorder_level = ?
                WHERE product_id = ?;
                """;

        jdbcTemplate.update(sql
                , product.getProductName()
                , product.getSupplierId()
                , product.getCategoryId()
                , product.getQuantityPerUnit()
                , product.getUnitPrice()
                , product.getUnitsInStock()
                , product.getUnitsOnOrder()
                , product.getReorderLevel()
                , id);
    }


}
