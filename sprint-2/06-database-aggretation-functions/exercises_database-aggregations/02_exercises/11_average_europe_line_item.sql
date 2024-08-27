-- 11. The average sales amount for all sales in Europe
-- (Use the customer_orders view)

-- (1 row) approx $605.99


SELECT *
FROM customer_orders;


SELECT AVG(sales_price * quantity) AS average_sales
FROM customer_orders
WHERE country in ('germany',  'switzerland' , 'france' , 'portugal', 'finland', 'poland', 'ireland', 'sweden', 'uk');





