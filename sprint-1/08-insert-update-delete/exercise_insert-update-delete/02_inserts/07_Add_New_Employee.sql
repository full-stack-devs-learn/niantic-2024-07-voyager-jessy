USE northwind;

-- You were just hired by Northwind Traders, Inc and 
-- you need to add yourself as a Sales Associate to the Employees table.
-- Inlcude your:
    -- full name
    -- job title
    -- preferred title (Mr, Mrs, etc)
    -- Birthday
    -- hire date: (today)
    -- home address
-- leave all other fields null by default

SELECT *
FROM employees;

INSERT INTO employees
	(	first_name
		, last_name
        , title
        , title_of_courtesy
        , birth_date
        , hire_date
        , address
        , city
        , region
        , postal_code
        , country
        , notes
	)
VALUES
	( "Jessy"
    , "Cesena"
    ,"Sales Associate" 
    ,"Mrs."
    , "1993-09-03 00:00:00"
    , "2024-7-31 00:00:00" 
    , "555 No Way Jose Rd."
    , "Puyallup"
    , "WA"
    , "98373"
    , "USA"
    , ""
    );