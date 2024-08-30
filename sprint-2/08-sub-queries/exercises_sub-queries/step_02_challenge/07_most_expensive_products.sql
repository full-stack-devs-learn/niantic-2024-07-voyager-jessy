-- 7. expensive products report

-- Display the most expensive product in each category

-- Columns to include:
-- Category Name
-- Product Name
-- Unit price

-- NOTE: you can combine INNER JOIN and sub queries in the
-- query if you would like

-- (8 rows - one per category)
-- Beverages        Cte de Blaye            263.5000
-- Condiments       Vegie-spread            43.9000
-- Confections      Sir Rodney's Marmalade  81.0000
-- Dairy Products   Raclette Courdavault    55.0000
-- Grains/Cereals   Gnocchi di nonna Alice  38.0000
-- Meat/Poultry     Thringer Rostbratwurst  123.7900
-- Produce          Manjimup Dried Apples   53.0000
-- Seafood          Carnarvon Tigers        62.5000


USE northwind;

SELECT *
FROM products;


SELECT DISTINCT cat.category_name
	, highest_price.product_name
    , highest_price.highest_price
FROM categories AS cat
INNER JOIN ( 
	SELECT p.product_name
		, p.category_id
		, MAX(p.unit_price) AS highest_price
 	FROM products AS p
	GROUP BY p.product_name
 		, p.category_id
     ) AS highest_price ON cat.category_id = highest_price.category_id
 INNER JOIN products AS p ON highest_price.category_id = p.category_id 
 ORDER BY highest_price.highest_price DESC;



