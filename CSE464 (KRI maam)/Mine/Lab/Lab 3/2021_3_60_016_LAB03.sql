BEGIN
   EXECUTE IMMEDIATE 'CREATE TABLE del_history (
       deptno NUMBER(3),
       deleted_count NUMBER(5),
       deletion_date DATE
   )';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE = -955 THEN
         DBMS_OUTPUT.PUT_LINE('Table del_history already exists.');
      ELSE
         DBMS_OUTPUT.PUT_LINE(SQLERRM);
      END IF;
END;
/

DECLARE
   deleted_count NUMBER(5);
BEGIN
   DELETE FROM emp WHERE deptno = 50;
   deleted_count := SQL%ROWCOUNT;
   IF deleted_count > 0 THEN
      DBMS_OUTPUT.PUT_LINE(deleted_count || ' rows deleted from department 50.');
      INSERT INTO del_history (deptno, deleted_count, deletion_date)
      VALUES (50, deleted_count, SYSDATE);
      COMMIT;
   ELSE
      DBMS_OUTPUT.PUT_LINE('No rows deleted from department 50.');
   END IF;
   DELETE FROM emp WHERE deptno = 20;
   deleted_count := SQL%ROWCOUNT;

   IF deleted_count > 0 THEN
      DBMS_OUTPUT.PUT_LINE(deleted_count || ' rows deleted from department 20.');
      INSERT INTO del_history (deptno, deleted_count, deletion_date)
      VALUES (20, deleted_count, SYSDATE);
      COMMIT;
   ELSE
      DBMS_OUTPUT.PUT_LINE('No rows deleted from department 20.');
   END IF;
END;
/
SELECT * FROM del_history;
