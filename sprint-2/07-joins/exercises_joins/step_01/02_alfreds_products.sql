-- 2. The name of all products that
-- have been ordered by Alfreds Futterkiste
-- Include each product only once
-- (11 rows)

USE Northwind;


SELECT DISTINCT product_name
	, company_name
FROM customers AS c
INNER JOIN orders AS o
	on c.customer_id = o.customer_id
INNER JOIN order_details AS od
	ON o.order_id = od.order_id
INNER JOIN products AS p
	ON od.product_id = p.product_id
WHERE company_name = 'Alfreds Futterkiste';
    

