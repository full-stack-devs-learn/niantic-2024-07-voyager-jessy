USE northwind;

-- Insert 10 new products into the new Sporting Goods Category
-- You can leave the Supplier Id empty for now, but you need to include
-- the product name, category, price, units in stock (20), units on order (0)
-- and re-order level (10) for each product.

select * 
from products
WHERE category_id =  @new_id;


    INSERT INTO products
	(	product_name
		, category_id
        , unit_price
        , units_in_stock
        , units_on_order
        , reorder_level
	)
VALUES 
	( "Nike Dri-FIT Ankle Socks - Mens" , @new_id, 28.00, 20, 0, 10)
    , ( "Nike Dri-FIT Ankle Socks - Womens", @new_id, 28.00, 20, 0, 10)
    , ( "Nike Dri-FIT Ankle Socks - Kids", @new_id, 20.00, 20, 0, 10)
    , ( "Easton Eye Black" , @new_id, 7.99, 20, 0, 10)
    , ( "isplack Clean Sweep Face Wipes (25 Pack)" , @new_id, 11.99, 20, 0, 10)
    , ( "DSG Girls' Momentum Sports Bra" , @new_id, 15.00, 20, 0, 10)
    , ( "Hiking Shoes" , @new_id, 177.99, 20, 0, 10)
    , ( "Mouth Guard" , @new_id, 24.99, 20, 0, 10)
    , ( "One Piece Swimsuit - Girls" , @new_id, 12.99, 20, 0, 10)
    ,(	"Stanley 30 Oz. Tumbler", @new_id, 35.00, 20, 0, 10)
    
	