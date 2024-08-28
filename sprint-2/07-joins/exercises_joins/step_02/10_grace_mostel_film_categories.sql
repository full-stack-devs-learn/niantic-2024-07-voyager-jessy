-- 10. Count of films in each category
-- that GRACE MOSTEL has appeared in as an actress

-- include first_name, last_name, category_name, film_count

-- (11 rows)

USE sakila;

SELECT *
FROM category;

SELECT COUNT(f.film_id) AS film_count
	, cat.name
	, CONCAT(a.first_name, ' ', a.last_name) AS actor
FROM category AS cat
INNER JOIN film_category AS fc
	ON cat.category_id = fc.category_id
INNER JOIN film AS f
	ON fc.film_id = f.film_id
INNER JOIN film_actor AS fa
	ON f.film_id = fa.film_id
INNER JOIN actor AS a
	ON fa.actor_id = a.actor_id
WHERE CONCAT(a.first_name, ' ', a.last_name) = 'grace mostel'
GROUP BY cat.name
	, CONCAT(a.first_name, ' ', a.last_name);
    
    
--     TECHNICALLY I USED FIRST NAME AND LAST NAME BUT THEY ARE CONCATED
    
    
    
