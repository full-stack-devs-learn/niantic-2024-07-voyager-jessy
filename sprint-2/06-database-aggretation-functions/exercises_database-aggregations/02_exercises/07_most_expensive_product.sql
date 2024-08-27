-- 7. Select the price of the most expensive product

-- (1 row)


SELECT *
FROM customer_orders
ORDER BY sales_price DESC;

SELECT MAX(sales_price) AS most_expensive_product
FROM customer_orders;
