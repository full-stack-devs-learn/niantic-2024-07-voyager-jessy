-- 13. Category popularity report

-- return a list of category names and the number of times
-- a film in that category has been rented

-- sort by most popular category first

-- (16 rows)

USE sakila;


SELECT *
FROM category;

SELECT *
FROM category AS cat
INNER JOIN film_category AS fc
	ON cat.category_id = fc.category_id
INNER JOIN film AS f
	ON fc.film_id = f.film_id
INNER JOIN inventory AS i
	ON f.film_id = i.film_id
INNER JOIN rental AS r
	ON i.inventory_id = r.inventory_id;


SELECT cat.name
	, COUNT(r.inventory_id) AS total_rental
FROM category AS cat
INNER JOIN film_category AS fc
	ON cat.category_id = fc.category_id
INNER JOIN film AS f
	ON fc.film_id = f.film_id
INNER JOIN inventory AS i
	ON f.film_id = i.film_id
INNER JOIN rental AS r
	ON i.inventory_id = r.inventory_id
GROUP BY cat.name
ORDER BY COUNT(r.inventory_id) DESC;


