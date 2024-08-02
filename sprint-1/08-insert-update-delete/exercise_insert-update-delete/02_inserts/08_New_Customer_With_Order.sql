-- Create a full script with variables that allows you 
-- to add a new Customer into the database. Then create an order for them
-- that includes 5 products. Create 5 variables at the top of the script
-- that store the 5 product names the customer wants to buy. You will use
-- the product names to find the id

-- Requirements
/*
    I should be able to run the script on my machine without having to
    write any queries to look up the id's of any tables. (The only id that
    I should have to know is the new CustomerId - which is a 5 letter code 
    that we will choose )

    Use variables at the top of the script to collect User Input. The rest 
    of the script should run without hardcoding ANY values.

    I.E. if I want to add a new customer, and order, I should be able 
    to change the variables at the beginning of the script, and run the whole
    script.
*/

/*
Customer must include: 
    Customer Id: 5 letter code
    Company Name: (You can use chatgpt or https://businessnamegenerator.com to pick a name)
    Contact Name: (you can use chatgpt or http://random-name-generator.info to pick a name)
    Address
    City
    Region
    Postal Code
    Country

Order:
    Order id: auto generated
    Customer Id: id from the inserted customer
    Order Date: today's date
    Ship Name: Contact name
    Ship Address: The company address information

OrderDetails: (Create 5 line items)
    Order Id: the one created above
    Product Id: use the product names to select/find the id of each product
    Unit Price: use the default list price of each product
    Quantity: you decide - between 1-10
    Discount: 0
*/
-- setting variables for th NEW CLIENT 
SET @customer_id = "GNAWZ"
	, @company_name = "Gnawz LLC"
    , @contact_name = "Jessy Cesena"
    , @address = "1234 55th Ave Ct E"
    , @city = "Puyallup"
    , @region = "WA"
    , @postal_code = 98373
    , @country = "USA"
;

SET @product1 = 'Scottish Longbreads'
	, @product2 = 'Chai'
    , @product3= 'Tofu'
    , @product4 = 'Easton Eye Black'
    , @product5= 'Queso Cabrales'
;

-- step one create customer and add them into database, create own CustomerID
INSERT INTO customers
(	customer_id
	, company_name
    , contact_name
    , address
    , city
    , region
    , postal_code
    , country
    )
Values
(	@customer_id
	, @company_name
    , @contact_name
    , @address
    , @city
    , @region
    , @postal_code
    , @country
);







-- now create a order to be added to the orders table for this customer 
INSERT INTO orders
	(	-- order_id -- auto generated
		customer_id -- one i made
        , order_date -- todays date
        , ship_name -- contact name
        , ship_address
        , ship_city
        , ship_region
        , ship_postal_code
        , ship_country
        )
VALUES
	(
		@customer_id
		, current_date
		, @customer_name
		, @address
		, @city
		, @region
		, @postal_code
		, @country
	);

select last_insert_id;

START TRANSACTION;

SET @order_id = LAST_INSERT_ID();
-- product 1
SELECT @product_id1 := product_id
	, @product_price1 := unit_price
FROM products
WHERE product_name = @product1;
-- product2
SELECT @product_id2 := product_id
	, @product_price2 := unit_price
FROM products
WHERE product_name = @product2;
-- product 3
SELECT @product_id3 := product_id
	, @product_price3 := unit_price
FROM products
WHERE product_name = @product3;
-- product 4
SELECT @product_id4 := product_id
	, @product_price4 := unit_price
FROM products
WHERE product_name = @product4;
-- product 5
SELECT @product_id5 := product_id
	, @product_price5 := unit_price
FROM products
WHERE product_name = @product5;








-- now create five item for this customer to order        
-- --- - OrderDetails: (Create 5 line items)
--     Order Id: the one created above
--     Product Id: use the product names to select/find the id of each product
--     Unit Price: use the default list price of each product
--     Quantity: you decide - between 1-10
--     Discount: 0   
    
 INSERT INTO order_details
	(	order_id  , product_id , unit_price , quantity , discount)
VALUES
		(@order_id, @product_id1, @product_price1, 5, 0)
		, (@order_id, @product_id2, @product_price2, 2, 0)
		, (@order_id, @product_id3, @product_price3, 3, 0)
		, (@order_id, @product_id4, @product_price4, 4, 0)
		, (@order_id, @product_id5, @product_price5, 9, 0)
;



select * 
from order_details
where order_id= @order_id;