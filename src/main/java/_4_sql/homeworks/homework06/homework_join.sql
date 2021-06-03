

/*1. Write a query to display the name, department number, and department name for
all employees.*/
SELECT e.name AS employee_name, d.department_id, d.name AS department_name
FROM employee e
       LEFT JOIN department d ON d.department_id :: text = e.department_id ;



/*2.  Create a unique listing of all jobs that are in department 30.*/
SELECT DISTINCT e.job AS job, d.location AS location
FROM employee e
       LEFT JOIN department d ON d.department_id :: text = e.department_id
WHERE d.department_id = 30;



/*3. Write a query to display the employee name, department name, and location of all
employees who earn a commission.*/
SELECT e.name AS employee_name, d.name AS department_name, d.location
FROM employee e
       LEFT JOIN department d ON d.department_id :: text = e.department_id
WHERE e.cpmmissions IS NOT NULL;



/*4. Display the employee name and department name for all employees who have an A in their name. */
SELECT e.name AS employee_name, d.name AS department_name
FROM employee e
       LEFT JOIN department d ON d.department_id :: text = e.department_id
WHERE e.name LIKE '%A%';




/*5. Write a query to display the name, job, department number, and department name for all employees who work in DALLAS.*/
SELECT e.name AS employee_name, e.job AS job, d.department_id AS department_number, d.name AS department_name
FROM employee e
       LEFT JOIN department d ON d.department_id :: text = e.department_id
WHERE d.location = 'DALLAS';



/*6. Display the employee name and employee number along with their manager’s name and manager number. Label the columns Employee, Emp#, Manager, and Mgr#, respectively.*/
SELECT e.name AS "Employee", e.employee_id AS "Emp#", e2.name AS "Manager", e.manager_id AS "Mgr#"
FROM employee e
       LEFT JOIN employee e2 on e.manager_id = e2.employee_id
WHERE e.manager_id IS NOT NULL;



/*7. Modify prvious query to display all employees including King, who has no manager.*/
SELECT e.name AS "Employee", e.employee_id AS "Emp#", e2.name AS "Manager", e.manager_id AS "Mgr#"
FROM employee e
       LEFT JOIN employee e2 on e.manager_id = e2.employee_id
WHERE e.manager_id IS NOT NULL OR e.name = 'KING';




/*8. Create a query that will display the employee name, department number, and all the
employees that work in the same department as a given employee. Give each column an appropriate label.*/
SELECT e1.department_id AS department, e1.name AS employee, e2.name AS colleague
FROM employee e1, employee e2
WHERE e1.department_id = e2.department_id AND e1.employee_id <> e2.employee_id;


SELECT e1.department_id AS department, e1.name AS employee, e2.name AS colleague
FROM employee e1 FULL JOIN employee e2 ON e1.department_id = e2.department_id AND e1.employee_id <> e2.employee_id;




/*9.  Check the structure of the SALGRADE table. Create a query that will display the name, job, department name, salary, and grade for all employees.*/
/*Таблички SALGRADE не было потому я ее создал и заполнил значениями по своему мнению*/
CREATE TABLE salgrade(
  grade int PRIMARY KEY ,
  from_num int,
  to_num int
);
INSERT INTO salgrade(grade, from_num, to_num) VALUES (1, 0, 1199);
INSERT INTO salgrade(grade, from_num, to_num) VALUES (2, 1200, 1499);
INSERT INTO salgrade(grade, from_num, to_num) VALUES (3, 1500, 1999);
INSERT INTO salgrade(grade, from_num, to_num) VALUES (4, 2000, 3099);
INSERT INTO salgrade(grade, from_num, to_num) VALUES (5, 3100, 6000);


SELECT e.name AS employee_name,
       e.job AS job,
       d.name AS department_name,
       e.salary AS salary,
       g.grade
FROM employee e
       INNER JOIN department d ON d.department_id :: text  = e.department_id
       INNER JOIN salgrade g ON e.salary BETWEEN g.from_num AND g.to_num;






/*10. Create a query to display the name and hire date of any employee hired after employee Blake.*/
SELECT name, to_char(hiredate, 'dd-MON-yy') AS hiredate
from employee
WHERE hiredate < (SELECT hiredate
                  FROM employee e
                  WHERE e.name = 'BLAKE');


SELECT e1.name, to_char(e1.hiredate, 'dd-MON-yy') AS hiredate
FROM employee e1
       LEFT JOIN employee e2 ON e2.name = 'BLAKE'
WHERE e1.hiredate < e2.hiredate;



/*11. Display all employees’ names and hire dates along with their manager’s name and hire date for all employees who were hired before their managers. Label the columns Employee, Emp Hiredate, Manager, and Mgr Hiredate, respectively.*/
SELECT e1.name AS Employee,
       to_char(e1.hiredate, 'dd-MON-yy') AS Emp_hiredate,
       e2.name AS Manager,
       to_char(e2.hiredate, 'dd-MON-yy') AS Mgr_hiredate
FROM employee e1
       LEFT JOIN employee e2 ON e1.manager_id = e2.employee_id
WHERE e1.hiredate < e2.hiredate;