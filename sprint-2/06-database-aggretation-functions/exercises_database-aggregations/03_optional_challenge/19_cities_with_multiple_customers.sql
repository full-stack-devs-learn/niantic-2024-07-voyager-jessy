-- 19. List of all cities that have more than one customer.
-- Include City and total_customer_count.
-- Sort by total_customer_count desc
-- (use customers table)

-- (10 rows)

SELECT *
FROM customers;

SELECT city
	, count(city) as total_customer_count
FROM customers
GROUP BY city
HAVING count(city) >= 2
ORDER BY count(city) desc;




