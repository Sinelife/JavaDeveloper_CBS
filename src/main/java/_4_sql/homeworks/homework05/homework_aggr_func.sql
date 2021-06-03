/*1. Display average employees salary.*/
SELECT avg(salary) AS Average_Salary
FROM employee;


/*2. Display average employees salary whose job is 'Clerk'.*/
SELECT avg(salary) AS Average_Clerks_Salary
FROM employee
WHERE job = 'CLERK';


/*3. Display max employees salary.*/
SELECT max(salary) AS Employee_Max_Salary
FROM employee;


/*3. Display max salary of employees who receive commissions.*/
SELECT max(salary) AS Employee_Comm_Max_Salary
FROM employee
WHERE cpmmissions IS NOT NULL;


/*4. Display min employees salary.*/
SELECT min(salary) AS Employee_Min_Salary
FROM employee;


/*5. Display min  salary of  employees whose job is  'Manager'  or  'Clerk'.*/
SELECT min(salary) AS Employee_Min_Clerk_Manager_Salary
FROM employee
WHERE job IN('CLERK','MANAGER');


/*6. Display summary employees salary.*/
SELECT sum(salary) AS Sum_employee_salary
FROM employee;


/*7.  Display summary employees salary whose department number is 30.*/
SELECT sum(salary) AS Sum_employee_salary_in_30_dept
FROM employee
WHERE department_id = '30';


/*8. Convert to uppercase and display employees name column.*/
SELECT upper(name) AS upper_name
FROM employee;


/*10. Convert to uppercase and display employees names that contains 'S' or 'R' symbols.*/
SELECT upper(name) AS upper_name_with_S_And_R
FROM employee
WHERE name LIKE '%S%' OR name LIKE '%R%';


/*11. Convert to lowercase and display employees name column.*/
SELECT lower(name) AS lower_name
FROM employee;


/*12. Convert to lowercase and display employees names that ends with 'ES' or 'ER'.*/
SELECT lower(name) AS lower_names_with_es_er_end
FROM employee
WHERE name LIKE '%ER' OR name LIKE '%ES';


/*13. Display names and five first symbols of employees JOB column. */
SELECT name, substr(job, 0 , 6) AS job_5_symbols
FROM employee;


/*14. Display employees names and names length.*/
SELECT name, length(name) AS name_length
FROM employee;


/*15. Display employees names whose length is more then 5 characters.*/
SELECT name AS name_more_than_5_letters
FROM employee
WHERE length(name) > 5;


/*16. Display employees names, salaries and salaries rounded to integers. */
SELECT name, salary, round(salary) AS round_to_int_salary
FROM employee;


/*17. Display employees names, salaries and salaries rounded to the hundredths.*/
SELECT name, salary, round(0.1 + salary :: float / 100) * 100 AS round_to_hundreds_salary
FROM employee;


/*18. Display employees names, salaries and salaries rounded to nearest thousand.*/
SELECT name, salary, round(salary :: float / 1000) * 1000 AS round_salary_to_thousands
FROM employee;


/*19. Display current date.*/
SELECT to_char(now(), 'dd-mm-yyyy hh24:mi:ss*');


/*20. Display employees names and hiredates in following format:*/
SELECT name, to_char(hiredate, 'dd-mm-yyyy') AS hiredate
FROM employee;