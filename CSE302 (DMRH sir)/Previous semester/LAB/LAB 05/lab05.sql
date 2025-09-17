--find instructor who tought in both fall-2009 and spring 2010

--using in keyword
select distinct id from teaches where semester = 'Fall' and year = 2009 and id IN(
	select id from teaches where semester = 'Spring' and year = 2010);

--uisng exists
select distinct t1.id from teaches t1 where semester = 'Fall' and year = 2009 and exists(
	select * from teaches t2 where semester = 'Spring' and year = 2010
	and t1.id = t2.id);


----Find all courses taught in both the Fall 2009 semester and in the Spring 2010 semester

---using in 
SELECT DISTINCT course_id FROM 	section WHERE semester = 'Fall' and year = 2009 and course_id in (
	SELECT course_id FROM section WHERE semester = 'Spring' and year = 2010);

---using exists
SELECT DISTINCT s1.course_id FROM section s1 WHERE semester = 'Fall' and year = 2009 and exists (
	SELECT * FROM section s2 WHERE semester = 'Spring' and year = 2010
	and s1.course_id = s2.course_id);

-----------Find all students who have taken all courses offered in the Biology department.

select distinct s.id from student s where not exists(
	select course_id from course where dept_name = 'Biology'
	minus
	select course_id from takes t1 where t1.id = s.id);

-----------Find all students who have not taken all courses offered in the Biology department.

select distinct s.id from student s where exists(
	select course_id from course where dept_name = 'Biology'
	minus
	select course_id from takes t1 where t1.id = s.id);

----------Find names of instructors with salary greater than that of some (at least one) instructor in the
Biology department.

select name from instructor where salary > some(
	select salary from instructor where dept_name = 'Biology'
	);


-----------Find the average instructors’ salaries of those departments where the average salary is greater
than $42,000

--subquery in from 
select dept_name, value from (select dept_name, avg(salary) as value from instructor group by dept_name) temp
where temp.value > 42000;

--using having keyword
select dept_name, avg(salary) as value from instructor group by dept_name having avg(salary) > 42000;

--with keyword
with temp as 
	(select dept_name, avg(salary) as value from instructor group by dept_name)
select dept_name, value from temp where temp.value > 42000;


-----------find the  dept-wise avarage salary of instructor those departments in which the number of 
-----------students is more than or equal to 2

with temp as (select dept_name, count(id) from student group by dept_name having count(id) >= 2),
     temp1 as (select dept_name, avg(salary) as value from instructor group by dept_name)
	select value, temp.dept_name from temp, temp1 where temp1.dept_name = temp.dept_name;

select i.dept_name, avg(salary) from instructor i, (select dept_name, count(*) as num_student from student
	group by dept_name having count(*) >=2) temp
	where i.dept_name = temp.dept_name;


---find all the departments where the total salary of instructor of that department is grater than the avarage of the
---total salary at all department 

with temp as (select dept_name, sum(salary) as value from instructor group by dept_name),
     temp1 as (select avg(salary) as value from instructor)
	select temp.dept_name from temp, temp1 where temp.value > temp1.value ;

select dept_name from (select dept_name, sum(salary) as sum_salary from instructor group by dept_name) temp1, 
	(select avg(sum_salary) as avg_sum_salary from 
	(select dept_name, sum(salary) as sum_salary from instructor group by dept_name ) temp2
	) temp3
where temp1.sum_salary >= temp3.avg_sum_salary;


---------find the average total credit completed by students for those departments in which offered courses in which
--------majority (more than or equal to 50% student)
----------have achived a grade 'A' , 





---------Number of instructor for each dept 
--outer join

select dept_name, count(id) as num_inst from department natural left join instructor 
group by dept_name;

--subquery in the select clause
select dept_name, 
	(select count(*) from instructor i where d.dept_name = i.dept_name) as num_inst
	FROM department d ;









