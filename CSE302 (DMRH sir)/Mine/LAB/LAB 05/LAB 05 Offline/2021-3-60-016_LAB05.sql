--2021-3-60-016
-- Lab Task 05

--Q1.	----------(Without using subqueries)----------

	SELECT *
	FROM customer NATURAL JOIN branch NATURAL JOIN account NATURAL JOIN depositor
	WHERE customer.customer_city = branch.branch_city;

	----------(With using subqueries)----------

	SELECT *
	FROM customer
	WHERE customer.customer_city IN (SELECT branch.branch_city 
					 FROM branch NATURAL JOIN account NATURAL JOIN depositor
					 WHERE customer.customer_name = depositor.customer_name);


--Q2. 	----------(Without using subqueries)----------

	SELECT *
	FROM customer NATURAL JOIN branch NATURAL JOIN loan NATURAL JOIN borrower
	WHERE customer.customer_city = branch.branch_city;

	----------(With using subqueries)----------

	SELECT *
	FROM customer  
	WHERE customer.customer_city IN ( SELECT branch_city
					  FROM branch NATURAL JOIN loan NATURAL JOIN borrower
					  WHERE customer.customer_name = borrower.customer_name);


--Q3. 	----------(Without using HAVING clause)----------

	SELECT branch_city, avg_balance
	FROM (SELECT branch_city, avg(balance) as avg_balance, sum(balance) as sum 
	      FROM account NATURAL JOIN  branch
		Group by branch_city) temp
	WHERE temp.sum>1000;

	----------(With using HAVING clause)----------

	SELECT branch_city, AVG(balance) AS Avg_Bal, SUM(balance) AS TOT_bal
	FROM branch NATURAL JOIN account
	GROUP BY branch_city
	HAVING SUM(balance)>1000;


--Q4. 	----------(Without using HAVING clause)----------
	
	SELECT branch_city, avg_amount
	FROM (SELECT branch_city, AVG(amount) as avg_amount
		FROM branch NATURAL JOIN loan
		GROUP BY branch_city)
	WHERE avg_amount>1500;

	----------(With using HAVING clause)----------

	SELECT branch_city, AVG(amount) AS Avg_amount
	FROM branch NATURAL JOIN loan
	GROUP BY branch_city
	HAVING AVG(amount)>1500;


--Q5. 	----------(Without using ALL clause)----------

	SELECT customer_name, customer_street, customer_city
	FROM  account NATURAL JOIN depositor NATURAL JOIN customer 
	WHERE balance= (SELECT MAX(balance)
			FROM account);

	----------(With using ALL clause)----------

	SELECT customer_name, customer_street, customer_city
	FROM  account NATURAL JOIN depositor NATURAL JOIN customer 
	WHERE balance >= ALL (SELECT balance
			     FROM account);


--Q6. 	----------(Without using ALL clause)----------

	SELECT customer_name, customer_street, customer_city
	FROM  borrower NATURAL JOIN loan NATURAL JOIN customer
	WHERE amount= (SELECT MIN(amount)
			FROM loan);

	----------(With using ALL clause)----------

	SELECT customer_name, customer_street, customer_city
	FROM  borrower NATURAL JOIN loan NATURAL JOIN customer
	WHERE amount<= ALL (SELECT amount
				FROM loan);


--Q7. 	----------(With using IN keyword)----------

	SELECT distinct B.branch_name, B.branch_city
	FROM branch B
	WHERE B.branch_name IN(SELECT branch_name
				   FROM account NATURAL JOIN loan);


	----------(With using exists keyword)----------

	SELECT distinct branch_name, branch_city 
	FROM (Select * 
	      FROM Loan NATURAL JOIN branch) temp
	WHERE exists (SELECT branch_name 
		      FROM account 
		      WHERE temp.branch_name = account.branch_name);



--Q8. 	----------(With using NOT IN keyword)----------
	
	SELECT distinct customer_name, customer_city
	FROM customer NATURAL JOIN depositor
	WHERE customer_name NOT IN (SELECT  customer_name
				FROM loan NATURAL JOIN borrower NATURAL JOIN customer);

	----------(With using NOT exists keyword)----------

	SELECT distinct customer_name, customer_city
	FROM (SELECT * FROM account Natural join Depositor Natural join customer) temp
	WHERE NOT EXISTS (SELECT * 
			  FROM (SELECT * 
				FROM Loan Natural join borrower) temp2 
			   WHERE temp.customer_name = temp2.customer_name);




--Q9.	----------(With using  WITH clause)----------

	WITH temp (branch_name, SUM) as (Select branch_name, SUM(balance)
					FROM account NATURAL JOIN branch 
					GROUP BY branch_name)
	SELECT * 
	FROM temp
	WHERE temp.SUM > (Select AVG(SUM) 
				FROM temp); 


	----------(Without using  WITH clause)----------

	SELECT *
	FROM (SELECT branch_name, SUM(balance) as sum
		FROM  account NATURAL JOIN branch
		GROUP BY branch_name ) temp
	WHERE temp.sum> (SELECT AVG(sum)
			 FROM (SELECT branch_name, SUM(balance) as SUM
				FROM account NATURAL JOIN branch 
				GROUP BY branch_name)); 


--Q10.	----------(With using  WITH clause)----------

	WITH temp (branch_name, SUM) AS (SELECT branch_name, SUM(amount) as SUM
					FROM loan NATURAL JOIN branch
					GROUP BY  branch_name)
	SELECT *
	FROM temp
	WHERE temp.SUM < (Select AVG(SUM) 
				FROM temp); 


	----------(Without using  WITH clause)----------

	SELECT *
	FROM (SELECT branch_name, SUM(amount) as SUM
	      FROM loan NATURAL JOIN branch
	      GROUP BY  branch_name) temp
	WHERE temp.SUM < (SELECT AVG(SUM)
			  FROM (SELECT branch_name, SUM(amount) AS SUM
				FROM loan NATURAL JOIN branch
				GROUP BY branch_name));
			  
	


