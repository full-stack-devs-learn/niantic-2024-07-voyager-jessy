-- 9. Most Popular Film Categories
-- Return the total number of actors
-- who have acted in a category
-- sort most popular category to least

-- Columns: category_name, actor_count
--
-- (16 rows)



USE sakila;


SELECT COUNT(DISTINCT fa.actor_id) AS actor_count
    , cat.name
FROM category AS cat
INNER JOIN film_category AS fc
	ON cat.category_id = fc.category_id
INNER JOIN film AS f
	ON fc.film_id = f.film_id
INNER JOIN film_actor AS fa
	ON f.film_id = fa.film_id
GROUP BY cat.name
ORDER BY COUNT(DISTINCT fa.actor_id) DESC;
