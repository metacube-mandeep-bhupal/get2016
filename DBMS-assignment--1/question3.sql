/* insert data into table members */
INSERT INTO members(member_id, member_nm, addresssline1, addressline2, category) VALUES ("1001","mandeep","sitapura", "jaipur", "M");
INSERT INTO members(member_id, member_nm,addressline1,adddessline2,category) VALUES ("1002", "ARPIT","Jaipur","Rajasthan","F");
INSERT INTO members(member_id, member_nm,addressline1,adddessline2,category) VALUES ("1003","PULKIT","Jaipur","Rajasthan","F");

/* insert data into table subjects */
INSERT INTO subjects(subject_id, subject_nm) VALUES ("1001","Science");
INSERT INTO subjects(subject_id, subject_nm) VALUES ("1002","Maths");
INSERT INTO subjects(subject_id, subject_nm) VALUES ("1003","English");
INSERT INTO subjects(subject_id, subject_nm) VALUES ("1004","Hindi");

/* insert data into table publishers */
INSERT INTO publishers(publisher_id, publisher_nm) VALUES ("1","Sanjeev Publications");
INSERT INTO publishers(publisher_id, publisher_nm) VALUES ("2","S.Chand Publications");
INSERT INTO publishers(publisher_id, publisher_nm) VALUES ("3","TMH Publications");

/* insert data into table authors */
INSERT INTO authors(author_id, author_nm) VALUES ("1001","V. Ramchandran");
INSERT INTO authors(author_id, author_nm) VALUES ("1002","Kuldeep Chakraborty");
INSERT INTO authors(author_id, author_nm) VALUES ("1003","Rashmi Bansal");

/* insert data into table titles */
INSERT INTO titles(title_id, title_nm,subject_id,publisher_id) VALUES ("1001","IN THIN AIR","1002","3");
INSERT INTO titles(title_id, title_nm,subject_id,publisher_id) VALUES ("1002","THE SECRET","1004","1");
INSERT INTO titles(title_id, title_nm,subject_id,publisher_id) VALUES ("1003","STAY HUNGRY","1001","1");

/* insert data into table books */
INSERT INTO books(accession_no, title_id,purchase_dt,price,status) VALUES ("10","1001",'2014/05/18',599,"available");
INSERT INTO books(accession_no, title_id,purchase_dt,price,status) VALUES ("11","1002",'2014/06/11',235,"not available");
INSERT INTO books(accession_no, title_id,purchase_dt,price,status) VALUES ("12","1001",'2015/02/18',485,"available");

/* insert data into table book_issue */
INSERT INTO book_issue(issue_dt,accession_no,member_id,due_dt) VALUES ('2014/05/21',"10","1002",'2014/05/29');
INSERT INTO book_issue(issue_dt,accession_no,member_id,due_dt) VALUES ('2014/06/20',"11","1002",'2014/07/29');
INSERT INTO book_issue(issue_dt,accession_no,member_id,due_dt) VALUES ('2015/03/18',"10","1002",'2015/03/28');

/* insert data into table title_author */
INSERT INTO title_author(title_id,author_id) VALUES ("1001","1002");
INSERT INTO title_author(title_id,author_id) VALUES ("1002","1002");
INSERT INTO title_author(title_id,author_id) VALUES ("1003","1001");

/* insert data into table book_return */
INSERT INTO book_return(return_dt,accession_no,member_id,issue_dt) VALUES ('2014/05/27',"10","1002",'2014/05/21');
INSERT INTO book_return(return_dt,accession_no,member_id,issue_dt) VALUES ('2014/07/29',"12","1002",'2014/06/20');
 
 /* update data of column adddessline2 of table members */
SET SQL_SAFE_UPDATES = 0;
UPDATE members SET adddessline2="Jaipur";

/* update data of column adddessline1 of table members WHERE category = 'Premium Member'*/
UPDATE members SET addressline1 = "EPIP, Sitapura" WHERE category = "F";

/* remove the foriegn key constraints */
SET foreign_key_checks = 0;

/* delete all rows from publishers table */
TRUNCATE TABLE publishers;

/* re-implement the foriegn key constraints */
SET foreign_key_checks = 1;

/* Insert the sample data back in Publishers table using substitution variables */
SET @id="1";
SET @name="Oxford Publications";
INSERT INTO publishers(publisher_id, publisher_nm) VALUES (@id,@name);

SET @id="2";
SET @name="Raining Publications";
INSERT INTO publishers(publisher_id, publisher_nm) VALUES (@id, @name);

SET @id="3";
SET @name="Meta Publications";
INSERT INTO publishers(publisher_id, publisher_nm) VALUES (@id, @name);

/* remove the foriegn key constraints */
SET foreign_key_checks = 0;

/* Delete those rows of Titles table belonging to Publisher with publisher_id = 1 */
DELETE FROM titles WHERE publisher_id = "1";

/* re-implement the foriegn key constraints */
SET foreign_key_checks = 1;
 
