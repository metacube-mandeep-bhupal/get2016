/* Using database lis.*/
USE lis;

/* Display result in ascending order of issue date and within issue date in ascending order of member's name.*/
SELECT bi.issue_dt AS 'Issue Date', bi.accession_no AS 'Accession Number', bi.member_id AS 'Member Id', bi.due_dt AS 'Return Date', m.member_nm AS 'Member Name'
	FROM book_issue bi 
	LEFT JOIN book_return br ON bi.accession_no = br.accession_no
	LEFT JOIN members m ON bi.member_id = m.member_id
	ORDER BY bi.issue_dt, m.member_nm;
