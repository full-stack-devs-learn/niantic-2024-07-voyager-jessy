package com.niantic.services;

import com.niantic.models.Category;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


import javax.sql.DataSource;
import java.util.ArrayList;

public class CategoryDao
{
    private JdbcTemplate jdbcTemplate;
    private static CategoryDao categoryDao = new CategoryDao();

    public CategoryDao()
    {
        String databaseUrl = "jdbc:mysql://localhost:3306/budget";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource(){{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<Category> getAllCategories()
    {
        var categories = new ArrayList<Category>();

        String sql = """
                SELECT category_id
                    , category_name
                    , description
                FROM categories;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int categoryId = row.getInt("category_id");
            String categoryName = row.getString("category_name");
            String description = row.getString("description");

            var category = new Category(categoryId, categoryName, description);
            categories.add(category);
        }

        return categories;

    }

    public void addCategory (Category categories)
    {
        String sql = """
                INSERT INTO categories (category_id
                                    , category_name
                                    , description
                                    )
                VALUES (?
                    ,?
                    ,?
                    );
                """;

        jdbcTemplate.update(sql,
                categories.getCategoryId(),
                categories.getCategoryName(),
                categories.getDescription());

    }

    public Category getCategoryById(int searchId) {
        String sql = """
                SELECT category_id
                    , category_name
                    , description
                FROM categories
                WHERE category_id = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, searchId);

        while (row.next()) {


            int categoryId = row.getInt("category_id");
            String categoryName = row.getString("category_name");
            String description = row.getString("description");


            return new Category(categoryId, categoryName, description);
        }
        return null;
    }

    public void deleteCategory(int categoryId)
    {
        String sql = """
                DELETE FROM cateogries
                WHERE category_id = ?;
                """;

        jdbcTemplate.update(sql, categoryId);
    }






}
