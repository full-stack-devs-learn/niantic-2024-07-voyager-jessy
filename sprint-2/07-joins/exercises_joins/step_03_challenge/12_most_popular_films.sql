-- 12. Most Popular film report
-- return the name of the 10 most popular films
-- title and number of times each film was rented

-- which tables will you need to join?

--
-- (10 rows)

USE sakila;




SELECT f.title
	, count(r.customer_id) AS total_rental
FROM film AS f
INNER JOIN inventory AS i
	ON f.film_id = i.film_id
INNER JOIN rental AS r
	ON i.inventory_id = r.inventory_id
GROUP BY f.title
ORDER BY COUNT(r.customer_id) DESC
LIMIT 10;
