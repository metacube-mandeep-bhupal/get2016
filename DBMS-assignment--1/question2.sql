use library;

/*creating table authors*/
CREATE TABLE IF NOT EXISTS Authors(
  author_id CHAR(36) NOT NULL,
  author_nm VARCHAR(100) NOT NULL,
  PRIMARY key(author_id)
); 

/*creating table members*/
CREATE TABLE IF NOT EXISTS members
( member_id CHAR(50) NOT NULL,
 member_nm VARCHAR(100) NOT NULL,
 addressline1 VARCHAR(100) NOT NULL,
 addressline2 VARCHAR(100) NOT NULL,
 category VARCHAR(100) NOT NULL,
 PRIMARY KEY(member_id)
 
 );
 
 /* creating table subjects */
CREATE TABLE IF NOT EXISTS subjects
(
subject_id CHAR(50),
subject_nm VARCHAR(50),
PRIMARY KEY(subject_id)
);

/*creating table publishers*/
CREATE TABLE IF NOT EXISTS publishers
(
publisher_id CHAR(50),
publisher_nm VARCHAR(50),
PRIMARY KEY(publisher_id)
);

/*creating table titles*/
CREATE TABLE IF NOT EXISTS titles
(
title_id CHAR(50),
title_nm VARCHAR(100),
subject_id VARCHAR(100),FOREIGN KEY(subject_id) REFERENCES subjects(subject_id),
publisher_id VARCHAR(100), FOREIGN KEY (publisher_id) REFERENCES publishers(publisher_id),
PRIMARY KEY(title_id)
);

/*creating table title_author*/
CREATE TABLE IF NOT EXISTS title_author
(
	title_id char(50) NOT NULL, FOREIGN KEY(title_id) REFERENCES titles(title_id),
    author_id char(36) NOT NULL, FOREIGN KEY(author_id) REFERENCES authors(author_id)
);

/*creating table books*/
CREATE TABLE IF NOT EXISTS books
(
	accession_no CHAR(50) NOT NULL,
    title_id char(50) , FOREIGN KEY(title_id) REFERENCES titles(title_id),
    purchase_dt DATE,price int ,status VARCHAR(15),
    PRIMARY KEY(accession_no)
);

/*creating table book_issue*/
CREATE TABLE IF NOT EXISTS book_issue
(
issue_dt DATE ,
accession_no char(50) NOT NULL,FOREIGN KEY (accession_no) REFERENCES books(accession_no),
member_id char(50) NOT NULL,FOREIGN KEY (member_id) REFERENCES members(member_id),
due_dt DATE,
PRIMARY KEY(issue_dt)
);

/*creating table book_return*/
CREATE TABLE IF NOT EXISTS book_return
(
	return_dt date, 
    accession_no char(50) NOT NULL, FOREIGN KEY (accession_no) REFERENCES books(accession_no),
    member_id char(50) NOT NULL,FOREIGN KEY (member_id) REFERENCES members(member_id),
	issue_dt DATE,FOREIGN KEY (issue_dt) REFERENCES book_issue(issue_dt),
	PRIMARY KEY(return_dt)
);

/*show all tables*/
show tables;

/*alter definitions
ALTER TABLE book_issue MODIFY COLUMN 
issue_dt DATE DEFAULT CURDATE();

ALTER TABLE book_issue MODIFY COLUMN 
due_dt DATE DEFAULT DATE_ADD(issue_dt, INTERVAL 15 DAY);*/


/* Setting foreign key constraint off for deleting the member table and removing it*/

set FOREIGN_KEY_CHECKS=0;

DROP TABLE members;

/*create members table again*/


CREATE TABLE IF NOT EXISTS members (
member_id CHAR(50) NOT NULL,
 member_nm VARCHAR(100) NOT NULL,
 addressline1 VARCHAR(100) NOT NULL,
 addressline2 VARCHAR(100) NOT NULL,
 category VARCHAR(100) NOT NULL,
 PRIMARY KEY(member_id)
);

/* Creating references again for new member table*/
ALTER TABLE book_issue ADD 
CONSTRAINT fk_member_id_book_issue1 FOREIGN KEY (member_id) REFERENCES members (member_id);

ALTER TABLE book_return ADD 
CONSTRAINT fk_member_id_book_return1 FOREIGN KEY (member_id) REFERENCES members (member_id);

/*re-implement the foreign key constraints*/
SET foreign_key_checks = 1;
