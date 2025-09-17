Lab Task # 01 (Schema Definition):
(i)
CREATE TABLE account
(
        account_no char(5),
	balance NUMBER NOT NULL CHECK(balance>0),
	PRIMARY KEY(account_no)
);


(ii)
CREATE TABLE customer
(
        customer_no char(5),
	customer_name VARCHAR2(20) NOT NULL,
	customer_city VARCHAR2(10),
	PRIMARY KEY(customer_no)
);


(iii)
CREATE TABLE depositor
(
        account_no CHAR(5),
	customer_no CHAR(5),
	PRIMARY KEY(account_no,customer_no)
);





Lab Task # 02 (Schema Modification):
(i) ALTER TABLE customer ADD date_of_birth DATE;
(ii)ALTER TABLE customer DROP COLUMN date_of_birth;
(iii)ALTER TABLE depositor RENAME COLUMN account_no TO a_no; 
     ALTER TABLE depositor RENAME COLUMN customer_no TO c_no;

(iv) ALTER TABLE depositor ADD Constraint depositor_fk1 FOREIGN KEY(a_no) 
     REFERENCES account(account_no);
     ALTER TABLE depositor ADD Constraint depositor_fk2 FOREIGN KEY(c_no) 
     REFERENCES customer(customer_no);






Lab Task # 03 (Writing Queries):

INSERT INTO account VALUES ('A-101',12000);
INSERT INTO account VALUES ('A-102',6000);
INSERT INTO account VALUES ('A-103',2500);

INSERT INTO customer VALUES ('C-101','Alice','Dhaka');
INSERT INTO customer VALUES ('C-102','Annie','Dhaka');
INSERT INTO customer VALUES ('C-103','Bob','Chittagong');
INSERT INTO customer VALUES ('C-104','Charlie','Khulna');

INSERT INTO depositor VALUES ('A-101','C-101');
INSERT INTO depositor VALUES ('A-103','C-102');
INSERT INTO depositor VALUES ('A-103','C-104');
INSERT INTO depositor VALUES ('A-102','C-103');

SELECT account.account_no, account.balance,customer.customer_no, customer.customer_name,customer.customer_city,depositor.a_no,depositor.c_no
FROM customer JOIN depositor
ON customer_no= c_no 
JOIN account
ON account.account_no=depositor.a_no;



Lab Task # 04 (Queries):

(i) 	SELECT customer_name,customer_city 
	FROM customer;

(ii)	SELECT DISTINCT customer_city 
	FROM customer;

(iii)	SELECT account_no,balance 
     	FROM account
	WHERE balance>7000 ;

(iv)	SELECT customer_no,customer_name
     	FROM customer
	WHERE customer_city='Khulna';

(v)	SELECT customer_no,customer_name
     	FROM customer
	WHERE customer_city!='Dhaka';

(vi)	SELECT customer_name,customer_city
     	FROM customer JOIN depositor
	ON customer_no= c_no
 	JOIN account
	ON a_no= account_no
	WHERE balance>7000;

(vii)   SELECT customer_name,customer_city
     	FROM customer JOIN depositor
	ON customer_no= c_no
 	JOIN account
	ON a_no= account_no
	WHERE balance>7000 AND customer_city!='Khulna';

(viii)  SELECT account_no ,balance
     	FROM customer JOIN depositor
	ON customer_no= c_no
 	JOIN account
	ON a_no= account_no
	WHERE customer_city IN ('Dhaka','Khulna');

(x) 	SELECT customer_name,customer_no
     	FROM customer JOIN depositor
	ON customer_no= c_no
 	JOIN account
	ON a_no= account_no
	WHERE account_no=NULL;
