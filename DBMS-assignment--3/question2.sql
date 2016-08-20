/* Using Database lis */
USE library;

/* To display subjectwise information of number of books purchased.
 * Information should include subject name, subject id and number of books purchased */
SELECT s.subject_id AS 'Subject id', s.subject_nm AS 'Subject Name',COUNT(b.accession_no) AS 'Number of books' FROM subjects s
    INNER JOIN titles t ON s.subject_id = t.subject_id
    INNER JOIN books b ON t.title_id = b.title_id
    GROUP BY s.subject_id;
    
/* To display those rows from book_issue table where a book can be returned after 2 months.That is, difference between issue and due date is greater than 2 months*/
SELECT issue_dt AS 'Issue Date', due_dt AS 'Due Date', accession_no AS 'Book ID', member_id AS 'Member ID'
    FROM book_issue WHERE TIMESTAMPDIFF(MONTH, issue_dt, due_dt) > 2;

/* To display the list of books having price greater than the minimum price of books purchased so far */
SELECT accession_no AS 'Book Id', title_id AS 'Title Id', purchase_dt AS 'Purchase Date', price AS 'Price',
    status AS 'Status' FROM books WHERE price > (SELECT MIN(price) FROM books);
