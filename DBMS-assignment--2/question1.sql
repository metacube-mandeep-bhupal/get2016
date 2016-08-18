/*Display all the columns of table members*/
SELECT * FROM members;

/*Display the selected columns from members*/
SELECT member_id,member_nm,category FROM members;

/*Displays details of the row that posses category "F" available in table members*/
SELECT member_id,member_nm,category FROM members
where category = "F";

/*Displays distinct types of categories a available in category column of members */
SELECT DISTINCT category FROM members;

/*Displays member name and category according to the descending order of member name*/
SELECT member_nm,category
FROM members
ORDER BY member_nm DESC;

/* Select command to display all the titles, their subject and publishers.*/
SELECT  t.title_id,t.title_nm,s.subject_id,p.publisher_id
FROM titles t
LEFT JOIN subjects s
ON t.subject_id = s.subject_id
LEFT JOIN publishers p
ON t.publisher_id = p.publisher_id;

/* Displays the number of members present in each category. Output includes category and number of members belonging to that category.*/
SELECT category, COUNT(*) FROM members GROUP BY category;

/* Displays name of those members who belong to the category as to which member "Pulkit" belongs.*/
SELECT m.member_nm
FROM members m
INNER JOIN members m1
ON m.category = m1.category
WHERE m1.member_nm='Pulkit';

/* Displays the information regarding book issue date, accession number , member id, due date */
SELECT bki.issue_dt AS 'Issue Date', bki.accession_no AS 'Accession Number',
bki.member_id AS 'Member ID', bkr.return_dt FROM book_issue bki LEFT JOIN
book_return bkr ON bki.accession_no = bkr.accession_no;
