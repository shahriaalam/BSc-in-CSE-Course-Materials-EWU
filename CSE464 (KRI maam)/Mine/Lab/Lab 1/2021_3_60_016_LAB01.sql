EXERCISE 1:

begin
    dbms_output.put_line('Name: Alve');
    dbms_output.put_line('DOB: July 10, 2002');
    dbms_output.put_line('Mobile: 016');
end;
/



EXERCISE 2:

declare
    height NUMBER := 7; 
    width NUMBER := 5; 
    perimeter NUMBER;
    area NUMBER;
begin
    perimeter := 2 * (height + width);
    area := height * width;

    dbms_output.put_line('Height: ' || height || ' inches');
    dbms_output.put_line('Width: ' || width || ' inches');
    dbms_output.put_line('Perimeter: ' || perimeter || ' inches');
    dbms_output.put_line('Area: ' || area || ' square inches');
end;
/



EXERCISE 3:

declare
	total_days NUMBER := 565; 
	years NUMBER;
	weeks NUMBER;
	days NUMBER;
begin
	years := TRUNC(total_days / 365);
	weeks := TRUNC(MOD(total_days, 365) / 7);
	days := MOD(MOD(total_days, 365), 7); 

	dbms_output.put_line(total_days || ' days is approximately:');
	dbms_output.put_line(years || ' years');
	dbms_output.put_line(weeks || ' weeks');
	dbms_output.put_line(days || ' days');
end;
/



EXERCISE 4:

declare
    num1 INTEGER;
    num2 INTEGER;
    num3 INTEGER;
    max_num INTEGER;
begin
    num1 := &num1;
    num2 := &num2;
    num3 := &num3;
 
    max_num := num1;
    if num2 > max_num THEN
        max_num := num2;
    end if;
    if num3 > max_num THEN
        max_num := num3;
    end if;
    
    dbms_output.put_line('Maximum value of three numbers: ' || max_num);
end;
/



EXERCISE 5:

declare
    emp_id VARCHAR2(10);
    worked_hours NUMBER;
    salary_per_hour NUMBER;
    total_salary NUMBER;
begin
    emp_id := '&emp_id'; 
    worked_hours := &worked_hours;
    salary_per_hour := &salary_per_hour;

    total_salary := worked_hours * salary_per_hour;

    dbms_output.put_line('Employee ID = ' || emp_id);
    dbms_output.put_line('Salary = BDT ' || TO_CHAR(total_salary, 'FM999999999990.00'));
end;
/

