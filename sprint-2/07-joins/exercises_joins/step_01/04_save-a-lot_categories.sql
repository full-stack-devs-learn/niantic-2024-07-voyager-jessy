-- 4. I want to know what category is the most popular
-- category for my best customer.

-- SELECT the Company Name, Category, and the OrderCount
-- for Save-a-lot Markets. (my best customer)
-- (the order count specifies how many times a category
-- was included in their orders)

-- sort in the order of the most ordered category to the least

-- (8 rows)

USE northwind;


SELECT DISTINCT company_name
	, category_name
    , count(od.quantity)
FROM customers AS c
INNER JOIN orders AS o
	on c.customer_id = o.customer_id
INNER JOIN order_details AS od
	ON o.order_id = od.order_id
INNER JOIN products AS p
	ON od.product_id = p.product_id
INNER JOIN categories AS cat
	ON p.category_id = cat.category_id
WHERE company_name = 'Save-a-lot Markets'
GROUP BY category_name
	, company_name
ORDER BY count(od.quantity) DESC

;
