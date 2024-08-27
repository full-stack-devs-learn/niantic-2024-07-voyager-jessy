-- 18. Count the number of customers in each country
-- include the country and total_customer_count
-- (use customers table)

-- (21 rows)


SELECT *
FROM customers;

SELECT count(country) as total_customer_count
	, country
FROM customers
Group BY country;

