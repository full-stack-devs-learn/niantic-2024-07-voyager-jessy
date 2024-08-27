-- 20. Return the State with the most number of orders placed.
-- Include state / region and order_count.
-- (use customer_orders view)

-- do not include any orders for customers whose state/region is unknow

-- (1 rows)
-- SP   49



SELECT *
FROM customer_orders
Where region = 'sp';


SELECT  region
-- 	, count(quantity)
FROM customer_orders
WHERE region IS NOT NULL
GROUP BY region
ORDER BY count(region) desc
 ;

