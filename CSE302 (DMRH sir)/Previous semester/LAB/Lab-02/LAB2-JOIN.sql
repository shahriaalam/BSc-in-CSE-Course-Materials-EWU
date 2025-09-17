select name, tot_cred from student, department where student.dept_name = department.dept_name and department.building = 'Watson';


select name, department.dept_name from student, department where student.dept_name = department.dept_name and department.budget >= 100000;



select department.dept_name, ID, name from student, department where student.dept_name = department.dept_name and student.tot_cred > 70 and department.building = 'Watson';


select ID, name, salary from instructor, department where instructor.dept_name = department.dept_name and department.building = 'Painter';


select instructor.ID, instructor.name from instructor, teaches where instructor.ID = teaches.ID and teaches.semester = 'Fall' and teaches.year = '2009';

select student.ID, name from student, takes where student.ID = takes.ID and takes.semester = 'Fall' and takes.year = '2009';
