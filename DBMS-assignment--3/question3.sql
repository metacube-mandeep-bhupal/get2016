/* Using database library */
USE library;

/* To display total number of students, total number of faculty and total number of others in library information system in a single row */


/* To display the information of those titles that have been issued more than 2 times */
SELECT t.title_id AS 'Title Id', t.title_nm AS 'Title Name', t.subject_id AS 'Subject Id', t.publisher_id AS 'Publisher Id',b.accession_no AS 'Book Id' FROM titles t 
    INNER JOIN books b ON t.title_id = b.title_id
    INNER JOIN book_issue bi ON b.accession_no = bi.accession_no
    GROUP BY bi.accession_no HAVING COUNT(bi.accession_no) > 2;

/* To display information on books  issued to members of category other than 'F' */
SELECT b.accession_no AS 'Book Id', b.title_id AS 'Title Id',
    t.title_nm AS 'Title Name', m.member_nm AS 'Member Name', m.category AS 'Category' FROM books b
    INNER JOIN titles t ON b.title_id = t.title_id
    INNER JOIN book_issue bi ON b.accession_no = bi.accession_no
    INNER JOIN members m ON bi.member_id = m.member_id
    WHERE m.category != 'F';

/* To display information on those authors for which atleast one book has been purchased*/
SELECT a.author_id AS 'Author Id', a.author_name AS 'Author Name'
    FROM authors a
    INNER JOIN title_author ta ON a.author_id = ta.author_id
    INNER JOIN books b ON ta.title_id = b.title_id
    /*WHERE b.status LIKE 'p%'
    GROUP BY a.author_id HAVING COUNT(b.accession_no) > 0;*/
