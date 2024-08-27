-- 5. The sum of all sales
-- sales_price * quantity -- don't worry about discount
-- (Use the customer_order view)

-- (1 row) -- 1354489.59


SELECT *
FROM customer_orders;
-- Gregor typo = singular customer_order :(

SELECT SUM(sales_price * quantity) AS sum_of_all_sales
FROM customer_orders;
-- I think there's another Gregor typo in the expected row sum($31 off)



