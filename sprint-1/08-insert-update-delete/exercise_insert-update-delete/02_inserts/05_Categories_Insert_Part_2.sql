USE northwind;

-- Select the new Category id

Select last_insert_id();


SET @new_id = last_insert_id();


SELECT *
FROM categories
WHERE category_id = @new_id;

