EXERCISE 1:

DECLARE
   num NUMBER;
BEGIN

   num := &Enter_a_number;
   IF MOD(num, 3) = 0 AND MOD(num, 7) = 0 THEN
      DBMS_OUTPUT.PUT_LINE('The number ' || num || ' is a multiple of both 3 and 7.');
   ELSIF MOD(num, 3) = 0 THEN
      DBMS_OUTPUT.PUT_LINE('The number ' || num || ' is a multiple of 3.');
   ELSIF MOD(num, 7) = 0 THEN
      DBMS_OUTPUT.PUT_LINE('The number ' || num || ' is a multiple of 7.');
   ELSE
      DBMS_OUTPUT.PUT_LINE('The number ' || num || ' is not a multiple of 3 or 7.');
   END IF;
END;
/



EXERCISE 2:

SET NULL 'NULL';
DROP TABLE employee PURGE;
CREATE TABLE employee (
    emp_id NUMBER PRIMARY KEY,
    salary NUMBER(10, 2),
    bonus NUMBER(10, 2) DEFAULT NULL,
    annual_salary NUMBER(12, 2) DEFAULT NULL, 
    grade VARCHAR2(2) DEFAULT NULL,       
    result VARCHAR2(10) DEFAULT NULL     
);

INSERT INTO employee (emp_id, salary, bonus, annual_salary, grade, result)
VALUES (1001, 45000.00, NULL, NULL, NULL, NULL);
INSERT INTO employee (emp_id, salary, bonus, annual_salary, grade, result)
VALUES (1002, 32000.00, NULL, NULL, NULL, NULL);
COMMIT;
SELECT * FROM employee;





EXERCISE 3:

DECLARE
    v_emp_id         NUMBER := &Enter_emp_id; -- Input for employee ID
    v_monthly_salary NUMBER;
    v_annual_salary  NUMBER;
    v_bonus          NUMBER;
    v_total_salary   NUMBER;
    v_grade          VARCHAR2(1);
    v_result         VARCHAR2(10);

BEGIN
    SELECT salary INTO v_monthly_salary
    FROM employee
    WHERE emp_id = v_emp_id;

    v_annual_salary := v_monthly_salary * 12;
    v_bonus := v_annual_salary * 0.10;
    v_total_salary := v_annual_salary + v_bonus;

    IF v_total_salary >= 500000 THEN
        v_grade := 'A';
    ELSE
        v_grade := 'B';
    END IF;

    IF v_total_salary >= 500000 THEN
        v_result := 'pass';
    ELSE
        v_result := 'fail';
    END IF;

    UPDATE employee
    SET bonus = v_bonus,
        annual_salary = v_total_salary,
        grade = v_grade,
        result = v_result
    WHERE emp_id = v_emp_id;

    DBMS_OUTPUT.PUT_LINE('Employee ID: ' || v_emp_id);
    DBMS_OUTPUT.PUT_LINE('Monthly Salary: ' || v_monthly_salary);
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || v_annual_salary);
    DBMS_OUTPUT.PUT_LINE('Bonus: ' || v_bonus);
    DBMS_OUTPUT.PUT_LINE('Total Annual Salary: ' || v_total_salary);
    DBMS_OUTPUT.PUT_LINE('Grade: ' || v_grade);
    DBMS_OUTPUT.PUT_LINE('Result: ' || v_result);
    COMMIT;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee with ID ' || v_emp_id || ' not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END;
/


EXERCISE 4:

DECLARE
    input_string VARCHAR2(100) := '&Enter_String'; 
    i            PLS_INTEGER := 1;
    current_char CHAR(1); 
    vowels       PLS_INTEGER := 0;
    consonants   PLS_INTEGER := 0;
    digits       PLS_INTEGER := 0;

BEGIN
    WHILE i <= LENGTH(input_string) LOOP
        current_char := UPPER(SUBSTR(input_string, i, 1)); 
        
        IF current_char IN ('A', 'E', 'I', 'O', 'U') THEN
            vowels := vowels + 1;
        
        ELSIF current_char BETWEEN '0' AND '9' THEN
            digits := digits + 1;

        ELSIF current_char >= 'A' AND current_char <= 'Z' THEN
            consonants := consonants + 1;
        END IF;
        i := i + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Number of vowels: ' || vowels);
    DBMS_OUTPUT.PUT_LINE('Number of consonants: ' || consonants);
    DBMS_OUTPUT.PUT_LINE('Number of digits: ' || digits);
END;
/

