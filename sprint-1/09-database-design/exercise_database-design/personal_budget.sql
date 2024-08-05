DROP DATABASE IF EXISTS personal_budget; -- doesn't exist 

CREATE DATABASE personal_budget; -- created it now

USE personal_budget;  -- using this database from here on

-- create the tables I designed

CREATE TABLE household
(
	member_id INT NOT NULL AUTO_INCREMENT
    , member_name VARCHAR(10) NOT NULL
    , member_last_name VARCHAR(10) NOT NULL
    , primary_bank VARCHAR(10) NOT NULL
    , PRIMARY KEY (member_id)
);

CREATE TABLE categories
(
	category_id INT NOT NULL AUTO_INCREMENT
    , category_name VARCHAR(30) NOT NULL
    , description TINYTEXT NULL
    , PRIMARY KEY (category_id)
);

CREATE TABLE subcategories
(
	subcategory_id INT NOT NULL AUTO_INCREMENT
    , subcategory_name VARCHAR(20) NOT NULL
    , category_id INT NOT NULL
    , PRIMARY KEY(subcategory_id)
);


CREATE TABLE transactions
(
	transaction_id INT NOT NULL AUTO_INCREMENT
    , transaction_date DATE NOT NULL
    , company_name VARCHAR(40) NOT NULL
    , subcategory_id INT NOT NULL
    , amount DECIMAL(10,2) NOT NULL
    , member_Id INT NOT NULL
    , notes TINYTEXT NULL
    , PRIMARY KEY (transaction_id)
);

ALTER TABLE transactions
ADD CONSTRAINT fk_transactions_subcategories
FOREIGN KEY(subcategory_id) REFERENCES subcategories(subcategory_id)
;

ALTER TABLE transactions
ADD CONSTRAINT fk_transactions_member_id
FOREIGN KEY(member_id) REFERENCES household(member_id)
;

ALTER TABLE subcategories
ADD CONSTRAINT fk_subcategories_categories
FOREIGN KEY(category_id) REFERENCES categories(category_id)
;

INSERT INTO household (member_name, member_last_name, primary_bank)
VALUES ('Jessy', 'Cesena', 'BECU')
	, ('Daniel' ,'Capilla', 'CHASE')
;

INSERT INTO categories (category_id, category_name, description)
VALUES (1001, 'Housing', 'Anything that deals with where we live and how we live within those walls.')
	, (1002, 'Transportation', 'Dealing with our cars/any alternative means of transportation; DAILY.')
    , (1003, 'Food', 'If you paid for it and ate it, add it here.')
    , (1004, 'Healthcare', ' ie, Doctor''s visit, dentist, medicine, etc.')
    , (1005, 'Entertainment' , 'If it was a planned event or something fun to do, use this category.')
    , (1006, 'Vacation/Travel' , 'Any expenses that relate directly to a vaction/travel. Non Daily transportation expenses.')
;

INSERT INTO categories (category_name, description)
VALUES ('Pets', 'Anything related to the circus, vet bills, food, supplies, etc.')
;

INSERT INTO subcategories (subcategory_name, category_id)
VALUES ('Rent', 1001)
	, ('Gas' , 1002)
    , ('Groceries' , 1003)
    , ('Medication' , 1004)
    , ('Outings' , 1005)
    , ('Flights', 1006)
    , ('Utilities', 1001)
    , ('Eating Out', 1003)
    , ('Pet Food', 1007)
    , ('Vet Bills', 1007)
    , ('Pet Supply' , 1007)
    , ('Medical Visit' , 1004)
    , ('Hotel', 1006)
    , ('Internet', 1001)
    , ('Streaming Services', 1005)
    , ('Car Service', 1002)
;
INSERT INTO subcategories(subcategory_name, category_id)
VALUES( 'Cellphone', 1005)
;

UPDATE subcategories
SET subcategory_name = 'Mortgage'
WHERE subcategory_name = 'Rent'
AND subcategory_id = 1
;


ALTER TABLE transactions AUTO_INCREMENT = 01;

INSERT INTO transactions (transaction_id, transaction_date, company_name, subcategory_id, amount, member_id, notes)
VALUES
	(1, '2024-07-01', 'Pine Tree Veterinary', 10, 150.00, 1, 'Rowdy vaccinations')
	, (2, '2024-07-01', 'Fitness Quest', 5, 140.00, 2, 'bjj & gym payment')
	, (3, '2024-07-02', 'PRMI', 1, 3000.00, 1, 'mortgage')
    , (4, '2024-07-06', 'TPU', 7, 180.00, 2, 'Water & Electric')
    , (5, '2024-07-10', 'Sayas', 8, 24.00, 2, 'lunch while working')
    , (6, '2024-07-10', 'ARCO', 2, 46.00, 1, null )
    , (7, '2024-07-12', 'COSTCO', 3, 200.00, 2, null)
    , (8, '2024-07-12', 'COSTCO', 2, 45.00, 2,'Subaru gas')
    , (9, '2024-07-13', 'Chewy', 9, 80.00, 1, 'Parrot pellet bulk order')
    , (10, '2024-07-14', 'WINCO', 3, 98.72, 1, null)
    , (11, '2024-07-16', 'HULU', 15, 6.99, 2, null)
    , (12, '2024-07-19', 'Alaska Airlines', 6 , 230.26, 2,'flying to california to see mom')
    , (13, '2024-07-19', 'IN-N-OUT', 8, 15.43, 2, null)
    , (14, '2024-07-19', 'AMAZON Go', 8, 10.21, 1, 'coffee and sandwich')
    , (15, '2024-07-19', 'k1 Speed', 5, 56.82, 2, null)
	, (16, '2024-07-22', 'Regal Cinema', 5, 35.67, 2, 'random date night')
    , (17, '2024-07-23', 'Sound Family Medicine', 12, 176.23, 2,'physical')
    , (18, '2024-07-26', 'Babin DDS', 12, 160.65, 1, ' routine cleaning')
    , (19, '2024-07-30', 'XFINITY', 14, 150.36, 2, null)
    , (20, '2024-07-31', 'T-Mobile',17, 172.89 ,2, null)
    , (21, '2024-07-30', 'COSTCO', 9, 63.65, 1, 'cat and dog food')
    , (22, '2024-07-30', 'PhoTai', 8, 32.93, 1, null)
    , (23, '2024-07-31', 'Mazda', 16, 92.60, 1, 'mazda oil change')
;
   
   
-- build a script to enter data from here on out:
   
   SET @transaction_date = current_date()
   , @company_name = 'Regal South Hill'
   , @subcategory_id = 5
   , @amount = 32.54
   , @member_id = 2
   , @notes= 'new deadpool movie date'
   ;
   
   
   
   Insert INTO transactions( transaction_date, company_name, subcategory_id, amount, member_id, notes)
   VALUES (@transaction_date, @company_name, @subcategory_id, @amount, @member_id, @notes)
   ;
   
   
   
   
   
   
   
    