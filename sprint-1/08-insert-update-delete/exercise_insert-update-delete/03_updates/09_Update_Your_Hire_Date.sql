USE northwind;

-- write an update statement and change your hire date to 
-- Monday 2 weeks ago


UPDATE employees
SET hire_date = date_sub(current_date, interval 17 day)
WHERE employee_id = '11';


delete from employees
WHERE employee_id = 10;
