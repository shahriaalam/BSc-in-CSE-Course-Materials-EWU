--create view
create view v as 
	(select id, name from instructor
	where dept_name = 'Comp. Sci.');

select * from v;


--user_views 
select view_name, text, view_type_owner from user_views;

---SELECT user permission

select * from user_tab_privs where table_name = 'V';


---lab exercise 

1. create va view  's_v_1' that contains teh name, dept_name of 'Comp. Sci' and 'Elec. Eng.' Department student;

	create view S_V_1 AS
		(SELECT name, dept_name FROM student where dept_name in ('Comp. Sci.', 'Elec. Eng.'));


2. Give the select and insert permission on user1 view 's_v_1'

	grant select, insert on S_V_1 to user1; 

3. Give the select permission on user3 view 's_v_1' with grant option

	grant select on S_V_1 to user3 
		with grant option;

4. show the relevabt data of authorization from appropiate table
	select * from user_tab_privs where table_name = 'S_V_1';

5. insert a new tuple in s_v_1. is the view updateable ?

	insert into S_V_1 values ('Parvez', 'Comp. Sci.');
	
	=> as the non selected attribute id is not null therefore the view is not updateable;
