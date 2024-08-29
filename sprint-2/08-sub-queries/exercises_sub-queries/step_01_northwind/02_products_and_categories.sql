-- 2. Create a product categories report

-- Columns to include:
-- ------------------
-- Category Name
-- Product Name
-- Unit Price


-- Use a sub query to display the Category Name
-- you are not allowed to use a JOIN statment

-- sort by category name, then product name

USE Northwind;


SELECT p.product_name
	, (SELECT category_name
		FROM categories AS c
		WHERE p.category_id = c.category_id) AS category_name
	, p.unit_price
FROM products AS p
ORDER BY category_name
	, p.product_name;

