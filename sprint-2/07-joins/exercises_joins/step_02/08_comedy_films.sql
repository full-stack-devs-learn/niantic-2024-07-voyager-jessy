-- 8. Display the Category Name, and film title of all films
-- in the "Comedy" category

-- (58 rows)

USE sakila;

SELECT *
FROM category;

SELECT cat.name
	, f.title
FROM category AS cat
INNER JOIN film_category AS fc
	ON cat.category_id = fc.category_id
INNER JOIN film AS f
	ON fc.film_id = f.film_id
WHERE cat.name = 'comedy';

