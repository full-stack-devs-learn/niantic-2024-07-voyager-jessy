use northwind;

-- The name, city and state of 
-- all customers in Oregon (OR)
-- Expected: 4 rows

SELECT company_name
	, city
    , country
    , region
FROM customers
WHERE country = 'USA'
	AND region = 'OR';

