/* Using databse lis */
USE library;

/* To display information of books issued for more than 2 months.
 * The information should include member name, member id, title name, accession number, issue date, due date and issued for how many months and be sorted on 
 * member name and then on title name. */

SELECT m.member_nm AS 'Member Name', bi.member_id AS 'Member ID', t.title_nm AS 'Title', bi.accession_no AS 'Accession Number', bi.issue_dt AS 'Issue Date', bi.due_dt AS 'Due Date', br.return_dt AS 'Return Date',
    TIMESTAMPDIFF(MONTH, bi.issue_dt, IFNULL(br.return_dt, CURRENT_TIMESTAMP)) AS 'Number of Months' 
    FROM book_issue bi
    INNER JOIN members m ON bi.member_id = m.member_id
    INNER JOIN books b ON bi.accession_no = b.accession_no
    INNER JOIN titles t ON b.title_id = t.title_id
    LEFT JOIN book_return br ON br.accession_no = bi.accession_no 
        AND br.member_id = bi.member_id AND br.issue_dt = bi.issue_dt
    WHERE TIMESTAMPDIFF(MONTH, bi.issue_dt, IFNULL(br.return_dt, CURRENT_TIMESTAMP)) > 2 
    ORDER BY m.member_nm, t.title_nm;
    
/* To display those rows from members table having maximum length for member name */
INSERT INTO members(member_nm,addressline1,adddessline2,category) VALUES ("Saurav","Jaipur","Rajasthan","S");

SELECT member_nm AS Name, LENGTH(member_nm) AS LengthOfName FROM members 
where LENGTH(member_nm) = (SELECT MAX(LENGTH(member_nm)) FROM members);

    
/* To display the number of books issued so far */
SELECT COUNT(DISTINCT accession_no) AS BooksIssuedSoFar FROM book_issue;
