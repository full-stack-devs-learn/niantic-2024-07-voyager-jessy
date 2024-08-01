USE northwind;

-- Write a script that updates the price of all products 
-- within a category by a certain percent.
-- use variables to accept the Category name and the percent increase 

SELECT *
FROM products
WHERE category_id = @new_id;

SET @percent_Increase = '.10';


UPDATE	products
SET unit_price = unit_price + (unit_price* @percent_increase)
WHERE category_id = @new_id;