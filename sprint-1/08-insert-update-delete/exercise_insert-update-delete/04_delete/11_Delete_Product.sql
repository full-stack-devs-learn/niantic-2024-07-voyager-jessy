USE northwind;

-- delete one of your new sporting goods products
-- from the database
-- choose one that has not been purchased 

DELETE FROM products
WHERE product_id = '108';
-- bye bye stanley tumblers 


-- select*
-- from products
-- where category_id = @new_id;