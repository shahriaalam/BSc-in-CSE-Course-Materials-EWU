Lab Task # 01 (Creating a table):
(a)

CREATE TABLE instructor_2021360016(
        id NUMBER,
	name VARCHAR2(20),
	dept_name VARCHAR2(25),
	salary NUMBER,
	PRIMARY KEY(id)
);


(b)
CREATE TABLE course_2021360016(
        course_id VARCHAR2(20),
	title VARCHAR2(30),
	dept_name VARCHAR2(25),
	credits NUMBER,
	PRIMARY KEY(course_id)
);




Lab Task # 02 (Inserting data into a table):
(a)
INSERT INTO instructor_2021360016 values(10101, 'Srinivasan', 'Comp. Sci.' ,65000);
INSERT INTO instructor_2021360016 values(12121, 'Wu', 'Finance' ,90000);
INSERT INTO instructor_2021360016 values(15151, 'Mozart', 'Music' ,40000);
INSERT INTO instructor_2021360016 values(22222, 'Einstein', 'Physics' ,95000);
INSERT INTO instructor_2021360016 values(32343, 'El Said', 'History' ,60000);
INSERT INTO instructor_2021360016 values(33456, 'Gold', 'Physics' ,87000);
INSERT INTO instructor_2021360016 values(45565, 'Katz', 'Comp. Sci.' ,75000);
INSERT INTO instructor_2021360016 values(58583, 'Califieri', 'History' ,62000);
INSERT INTO instructor_2021360016 values(76543, 'Singh', 'Finance' ,80000);
INSERT INTO instructor_2021360016 values(76766, 'Crick', 'Biology' ,72000);
INSERT INTO instructor_2021360016 values(83821, 'Brandt', 'Comp. Sci.' ,92000);
INSERT INTO instructor_2021360016 values(98345, 'Kim','Elec. En' ,80000);


(b)
insert into course_2021360016 values ('BIO-101', 'Intro. to Biology', 'Biology', 4);
insert into course_2021360016 values ('BIO-301', 'Genetics', 'Biology', 4);
insert into course_2021360016 values ('BIO-399', 'Computational Biology', 'Biology', 3);
insert into course_2021360016 values ('CS-101', 'Intro. to Computer Science', 'Comp. Sci.', 4);
insert into course_2021360016 values ('CS-190', 'Game Design', 'Comp. Sci.', 4);
insert into course_2021360016 values ('CS-315', 'Robotics', 'Comp. Sci.', 3);
insert into course_2021360016 values ('CS-319', 'Image Processing', 'Comp. Sci.', 3);
insert into course_2021360016 values ('CS-347', 'Database System Concepts', 'Comp. Sci.', 3);
insert into course_2021360016 values ('EE-181', 'Intro. to Digital Systems', 'Elec. Eng.', 3);
insert into course_2021360016 values ('FIN-201', 'Investment Banking', 'Finance', 3);
insert into course_2021360016 values ('HIS-351', 'World History', 'History', 3);
insert into course_2021360016 values ('MU-199', 'Music Video Production', 'Music', 3);
insert into course_2021360016 values ('PHY-101', 'Physical Principles', 'Physics', 4);



Lab Task # 03 (Writing Queries):

i)   SELECT name FROM instructor_2021360016;

ii)  SELECT course_id,title FROM course_2021360016;

iii) SELECT name,dept_name FROM instructor_2021360016
		WHERE id = 22222;

iv)  SELECT title,credits FROM course_2021360016
		WHERE dept_name='Comp. Sci.';

v)   SELECT name,dept_name FROM instructor_2021360016
		WHERE salary> 70000;

vi)  SELECT title FROM course_2021360016
		WHERE credits>=4;

vii) SELECT name,dept_name FROM instructor_2021360016
		WHERE salary>=80000 and salary<=100000;

viii)SELECT title,credits FROM course_2021360016
		WHERE dept_name!='Comp. Sci.';

ix)  SELECT * FROM instructor_2021360016;

x)   SELECT *FROM course_2021360016
		WHERE dept_name=‘Biology’ AND credits!=4;



