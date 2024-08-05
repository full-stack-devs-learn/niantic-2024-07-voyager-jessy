
-- create variable for month
SET @month = MONTH(transaction_date) FROM transactions WHERE transaction_date = 7




CREATE VIEW housing_expenses AS
SELECT subcategory_name AS 'Subcategory'
	,sum(amount) AS 'Expense'
FROM transactions
	INNER JOIN subcategories on transactions.subcategory_id = subcategories.subcategory_id
    INNER JOIN categories on subcategories.category_id = categories.category_id
WHERE category_name = 'Housing'	
GROUP BY subcategory_name;

