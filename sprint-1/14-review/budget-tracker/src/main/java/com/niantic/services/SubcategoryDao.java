package com.niantic.services;

import com.niantic.models.Subcategory;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


import javax.sql.DataSource;
import java.util.ArrayList;


public class SubcategoryDao
{

    private JdbcTemplate jdbcTemplate;
    private static SubcategoryDao subcategoryDao = new SubcategoryDao();

    public SubcategoryDao()
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

    public ArrayList<Subcategory> getAllSubcategories()
    {
        var subcategories = new ArrayList<Subcategory>();

        String sql = """
                SELECT sub_category_id
                    , category_id
                    , sub_category_name
                    , description
                FROM sub_categories;
                """;

        var row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int subcategoryId = row.getInt("sub_category_id");
            int categoryId = row.getInt("category_id");
            String subcategoryName = row.getString("sub_category_name");
            String description = ("description");

            var subcategory = new Subcategory(subcategoryId, categoryId, subcategoryName, description);
            subcategories.add(subcategory);
        }
        return subcategories;
    }

   public void addSubcategory(Subcategory subcategory)
   {
       String sql = """
               INSERT INTO sub_categories(category_id
                                    , sub_category_name
                                    , description
               VALUES(? , ?, ?);
               """;
       jdbcTemplate.update(sql
                        , subcategory.getCategoryId()
                        , subcategory.getSubcategoryName()
                        , subcategory.getDescription());
   }

   public void deleteSubcategory(int id)
   {
       String sql = "DELETE FROM sub_categories WHERE sub_categories_id = ?;";

       jdbcTemplate.update(sql, id);

   }


}
