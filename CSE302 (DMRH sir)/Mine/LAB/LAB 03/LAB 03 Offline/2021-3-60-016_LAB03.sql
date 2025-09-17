--2021-3-60-016
-- Lab Task 03

--Q1.	SELECT branch_name,branch_city
	FROM branch
	WHERE assets>=1000000;

--Q2.	SELECT account_number,balance
	FROM account
	WHERE branch_name=‘Downtown’ 
	OR balance BETWEEN 600 AND 750;

--Q3.	SELECT account_number
	FROM account NATURAL JOIN branch
	WHERE branch_city='Rye';

--Q4.	SELECT loan.loan_number 
	FROM loan, customer, borrower 
	WHERE loan.loan_number= borrower.loan_number 
	AND customer.customer_name= borrower.customer_name 
	AND amount>=1000 AND customer_city= 'Harrison';

--Q5. 	SELECT * 
	FROM account 
	ORDER BY balance DESC;

--Q6. 	SELECT * 
	FROM customer 
	ORDER BY customer_city;

--Q7. 	SELECT customer_name
	FROM account NATURAL JOIN depositor
	INTERSECT
	SELECT customer_name
	FROM borrower NATURAL JOIN loan;

--Q8. 	(SELECT customer_name, customer_street, customer_city
	FROM customer NATURAL JOIN depositor NATURAL JOIN account)
	INTERSECT
	(SELECT customer_name, customer_street, customer_city
	FROM customer NATURAL JOIN borrower NATURAL JOIN loan);

--Q9. 	(SELECT customer_name, customer_city
	FROM customer NATURAL JOIN borrower NATURAL JOIN loan)
	MINUS
	(SELECT customer_name, customer_city
	FROM customer NATURAL JOIN account NATURAL JOIN depositor);

--Q10. 	SELECT SUM(assets) as Tot_asset
	FROM branch;

--Q11. 	SELECT  branch_name,avg(balance) as Avg_balance
	FROM account
	GROUP BY branch_name;

--Q12. 	SELECT branch_city, avg(balance) as avg_balance 
	FROM account NATURAL JOIN branch 
	GROUP BY branch_city;

--Q13. 	SELECT branch_name,min(amount) as Low_loan
	FROM account NATURAL JOIN loan
	GROUP BY branch_name;

--Q14. 	SELECT branch_name,count(loan_number) as Tot_loan
	FROM loan
	GROUP BY branch_name;

--Q15. 	SELECT customer_name, account_number 
	FROM account NATURAL JOIN customer NATURAL JOIN depositor
	WHERE balance=(SELECT max(balance)FROM account);











