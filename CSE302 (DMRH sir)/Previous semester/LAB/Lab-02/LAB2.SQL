ALTER TABLE AUTHOR ADD author_phone VARCHAR2(11) NOT NULL;

ALTER TABLE BOOK ADD book_pub_year NUMBER;

--DELETE AN EXITING ATTRIBUTES
ALTER TABLE AUTHOR DROP COLUMN author_phone;

--modifing an existing attributes

ALTER TABLE BOOK MODIFY book_pub_year CHAR(2);

-- Rename a column 

ALTER TABLE AUTHOR RENAME COLUMN author_nid TO national_id;

--Rename a table;

ALTER TABLE PUBLISH RENAME TO WRITES;

--creating a table cricketer (dummy)
CREATE TABLE CRICKETER(
	cricketer_id NUMBER,
	cricketer_name VARCHAR2(20),
	cricketer_type VARCHAR2(10),
	batting_avg NUMBER,
	bowling_avg NUMBER
)


--ADD A CONSTRAINT

ALTER TABLE CRICKETER ADD CONSTRAINT CRICKETER_PK PRIMARY KEY (cricketer_id);
ALTER TABLE CRICKETER ADD CONSTRAINT CRICKETER_CH CHECK (batting_avg >0);


--Droping existing constraint
ALTER TABLE CRICKETER DROP CONSTRAINT CRICKETER_CH;

-- COUNTRY TABLE
CREATE TABLE COUNTRY(
    COUNTRY_ID VARCHAR2(3),
    COUNTRY_NAME VARCHAR2(20),
    COUNTRY_CAPITAL VARCHAR2(10)
);

-- LOCATIONS TABLE
CREATE TABLE LOCATIONS(
    LOCATION_ID NUMBER,
    STREET_ADDRESS VARCHAR2(20),
    POSTAL_CODE VARCHAR2(4),
    CITY VARCHAR2(10),
    DIVISION VARCHAR2(10),
    COUNTRY_ID VARCHAR2(3)
);

1.
ALTER TABLE LOCATIONS ADD REGION_ID NUMBER;

2.
ALTER TABLE LOCATIONS MODIFY COUNTRY_ID NUMBER;

3.
ALTER TABLE LOCATIONS DROP COLUMN CITY;

4. 
ALTER TABLE LOCATIONS ADD CONSTRAINT LOCATIONS_PK PRIMARY KEY (LOCATION_ID);

5.
ALTER TABLE COUNTRY ADD CONSTRAINT COUNTRY_PK PRIMARY KEY (COUNTRY_ID);

6.
ALTER TABLE LOCATIONS ADD CONSTRAINT LOCATIONS_FK FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY(COUNTRY_ID);

7.
ALTER TABLE COUNTRY RENAME TO COUNTRY_INFO;

8.

ALTER TABLE LOCATIONS RENAME COLUMN STREET_ADDRESS TO ADDR;




select name, tot_cred from student, department where student.dept_name = department.dept_name and department.building = 'Watson';


select name, department.dept_name from student, department where student.dept_name = department.dept_name and department.budget >= 100000;



select department.dept_name, ID, name from student, department where student.dept_name = department.dept_name and student.tot_cred > 70 and department.building = 'Watson';

--find instructor id, name and slaray whohave theri departments located in 'Painter' buildings


select ID, name, salary from instructor, department where instructor.dept_name = department.dept_name and department.building = 'Painter';


select instructor.ID, instructor.name from instructor, teaches where instructor.ID = teaches.ID and teaches.semester = 'Fall' and teaches.year = '2009';

select student.ID, name from student, takes where student.ID = takes.ID and takes.semester = 'Fall' and takes.year = '2009';










