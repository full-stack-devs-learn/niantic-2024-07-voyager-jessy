USE northwind;

-- Write a script that updates the price of all products 
-- within a category by a certain percent.
-- use variables to accept the Category name and the percent increase 

SELECT @category_id := category_id
FROM categories
WHERE category_name = @category_name;


SET @category_name = 'Sporting Goods';

SET @percent_Increase = 1.3;  -- could use .3 for this as well


UPDATE	products
SET unit_price = unit_price * @percent_increase
WHERE @new_id = @category_name;



SELECT PRODUCT_ID
 	, PRODUCT_NAME
     , UNIT_PRICE
     , UNIT_PRICE * @PERCENT_INCREASE
     , CATEGORY_ID
FROM PRODUCTS
WHERE CATEGORY_ID = @CATEGORY_ID;