SELECT * FROM personal_budget.monthly_total;


-- BELOW IS HOW I DID THIS!

-- CREATE VIEW monthly_total AS
-- SELECT sum(amount) 'Expense' , category_name 'Category'
-- FROM transactions
-- 	INNER JOIN subcategories on transactions.subcategory_id = subcategories.subcategory_id
--     INNER JOIN categories on subcategories.category_id = categories.category_id
-- Group by category_name;
