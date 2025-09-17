GRANT RESOURCE, CONNECT, CREATE SESSION, CREATE TABLE,
CREATE VIEW, CREATE ANY TRIGGER, CREATE ANY PROCEDURE, CREATE
SEQUENCE, CREATE SYNONYM, UNLIMITED TABLESPACE TO CSE302_S1_SM23;


CREATE TABLE Author(
	author_id varchar2(4),
	author_name varchar2(30) NOT NULL,
	author_gender char(1),
	author_dob date,
	author_NID char(10),
	PRIMARY KEY(author_id),
	UNIQUE(author_NID)
);


CREATE TABLE Book(
	ISBN varchar2(14),
	book_title varchar2(30),
	book_genre varchar2(15),
	number_of_pages number,
	book_price number,
	PRIMARY KEY(ISBN),
	CHECK(number_of_pages>0),
	CHECK(book_price>0)
);


CREATE TABLE Publish(
	ISBN varchar2(14),
	author_id varchar2(4),
	publish_date DATE,
	PRIMARY KEY (ISBN, author_id),
	FOREIGN KEY (ISBN) REFERENCES Book,
	FOREIGN KEY (author_id) REFERENCES Author
);


INSERT INTO Author VALUES('A-01', 'Alice', 'F', '01-JAN-80', '1234567890');
INSERT INTO Author VALUES('A-02', 'Bob', 'M', '04-May-82', '9876543210');
INSERT INTO Author VALUES('A-03', 'Humaiyan Ahmmed', 'M', '13-NOV-48', '5845727548');


INSERT INTO Book VALUES('1234-5-678-12', 'Title 1', 'Sci-fi', 120, 200.00);
INSERT INTO Book VALUES('9876-5-432-01', 'Title 2', 'Romantic', 250, 500.00);
INSERT INTO Book VALUES('5568-5-432-10', 'Himu', 'Fiction', 250, 347.00);

INSERT INTO Publish VALUES('1234-5-678-12', 'A-01', '08-APR-23');
INSERT INTO Publish VALUES('1234-5-678-12', 'A-02', '08-May-23');
INSERT INTO Publish VALUES('9876-5-432-01', 'A-01', '08-FEB-23');
INSERT INTO Publish VALUES('5568-5-432-10', 'A-03', '08-FEB-93');


UPDATE Book set number_of_pages = 220 where ISBN= '5568-5-432-10';

UPDATE Book set book_price = 650 where ISBN= '9876-5-432-01';


delete from Author where author_id = 'A-01';


select * from Author where author_gender = 'F';

select author_id, author_name from Author where author_gender = 'F';

----Quires on Books--------------

--find the title which have the price higher than 1000
SELECT book_title FROM Book WHERE book_price > 1000;

--find ISBN, title and genre of book price in between 500 to 800
SELECT ISBN, book_title, book_genre FROM Book WHERE book_price >= 500 and book_price <= 800 ;
SELECT ISBN, book_title, book_genre FROM Book WHERE book_price BETWEEN 500 and 800 ;

--find book title and price of the books having less than 200 pages 
SELECT book_title, book_price FROM Book WHERE number_of_pages < 200;

--FIND books data which have number of pages more than 300 or their price is more than 2000

SELECT * FROM Book WHERE number_of_pages > 300 or book_price > 2000;

--find isbn and book title of 'romantic and 'sci-fi books;


SELECT ISBN, book_title from Book where book_genre = 'Romantic' or book_genre = 'Sci-fi';
SELECT ISBN, book_title from Book where book_genre in('Romantic','Sci-fi');


--find isbn and book title of except 'romantic and 'sci-fi books;
SELECT ISBN, book_title from Book where book_genre not in('Romantic','Sci-fi');
SELECT ISBN, book_title from Book where book_genre != 'Romantic' and book_genre != 'Sci-fi';


