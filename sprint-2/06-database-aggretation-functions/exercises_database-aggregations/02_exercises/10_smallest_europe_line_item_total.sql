-- 8. The smallest line item amount made in Europe
-- (Use the customer_orders view)

-- (1 row) $4.80

SELECT *
FROM customer_orders
WHERE country in ('germany',  'switzerland' , 'france' , 'portugal', 'finland', 'poland', 'ireland', 'sweden', 'uk') 
ORDER BY sales_price ASC;

SELECT MIN(sales_price * quantity)
FROM customer_orders
WHERE country in ('germany',  'switzerland' , 'france' , 'portugal', 'finland', 'poland', 'ireland', 'sweden', 'uk');




