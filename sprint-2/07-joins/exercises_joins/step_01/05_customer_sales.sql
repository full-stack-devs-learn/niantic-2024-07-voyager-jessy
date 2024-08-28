-- 5. The order details table includes the line item for each sale.
-- the Line Total is the SalesPrice * Quantity - Discount%.

-- I want a customer sales report
-- include customer names (compay_name), and their total sales amount (after discount)
-- sorted by sales total highest to lowest

-- The first 3 rows should be
-- CompanyName			SalesTotal
-- QUICK-Stop			110277.31
-- Ernst Handel			104874.98
-- Save-a-lot Markets	104361.95

-- (89 rows)

USE northwind;

-- lets first see the data nneded to calculate Line Total requested

SELECT company_name
	, unit_price
    , quantity
    , discount
FROM customers AS c
INNER JOIN orders AS o
	ON c.customer_id = o.customer_id
INNER JOIN order_details AS od
	ON o.order_id = od.order_id;
    



SELECT DISTINCT company_name
	, sum(od.unit_price * od.quantity) - SUM( od.unit_price * od.quantity * od.discount) AS line_total
FROM customers AS c
INNER JOIN orders AS o
	ON c.customer_id = o.customer_id
INNER JOIN order_details AS od
	ON o.order_id = od.order_id
GROUP BY company_name
ORDER BY sum(od.unit_price * od.quantity) - SUM( od.unit_price * od.quantity * od.discount) DESC;

-- or could be written with one less aggregate
-- SELECT DISTINCT company_name
-- 	, sum((od.unit_price * od.quantity) - (od.unit_price * od.quantity * od.discount)) AS line_total
-- FROM customers AS c
-- INNER JOIN orders AS o
-- 	ON c.customer_id = o.customer_id
-- INNER JOIN order_details AS od
-- 	ON o.order_id = od.order_id
-- GROUP BY company_name
-- ORDER BY sum((od.unit_price * od.quantity) - ( od.unit_price * od.quantity * od.discount)) DESC;




