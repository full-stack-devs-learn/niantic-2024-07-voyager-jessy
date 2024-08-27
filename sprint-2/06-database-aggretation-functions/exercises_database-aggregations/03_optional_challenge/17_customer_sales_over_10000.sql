-- 16. Total sales by any customer who has spent more than $10000
-- Include the CompanyName, State and TotalSales
-- Sort by total sales desc
-- (Use the customer_orders view)

-- (6 rows)


SELECT *
FROM CUSTOMER_ORDERS;

SELECT company_name
	, region
	, (sales_price * quantity) as total_sales
FROM customer_orders
WHERE (sales_price * quantity) > 10000
ORDER BY (sales_price * quantity) DESC;





