SELECT DEPT_NAME, COUNT(ID) FORM INSTRUCTOR GROUP BY DEPT_NAME;

SELECT DEPT_NAME, MAX(SALARY) from INSTRUCTOR WHERE DEPT_NAME = 'Comp. Sci.' or DEPT_NAME = 'History' or DEPT_NAME = 'Physics' GROUP BY DEPT_NAME order by avg(SALARY) desc;


SELECT DEPT_NAME, MAX(SALARY) from INSTRUCTOR WHERE DEPT_NAME in ('Comp. Sci.','History', 'Physics') GROUP BY DEPT_NAME order by avg(SALARY) desc;

select Building, sum(Years_employed) from Employees group by Building;

select Building, count(*) from Employees order by Building

select role, avg(Years_employed) from Employees group by Years_employed;





select role, count(role) from Employees group by role

select sum(Years_employed) from Employees where role = 'Engineer' group by role;




select name from student natural join takes where year = 2009 and semester = 'Fall' intersect select name from student natural join takes where year = 2010 and semester = 'Spring' ;