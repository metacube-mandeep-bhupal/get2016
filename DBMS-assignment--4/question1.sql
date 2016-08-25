USE library;

/*Write a SELECT command to display name of those members
who belong to the category as to which member
“Jon Snow” belongs.*/
select member_nm from members
where category= (select category from members where member_nm = 'Jon Snow');

/*Write a SELECT command to display information on the books
that have not been returned till date. The information should
include book issue date, title, member name and due date.*/
select b.accession_no, bi.issue_dt,t.title_nm,m.member_nm,bi.due_dt
from book_issue bi
Inner Join members m ON m.member_id=bi.member_id
Inner Join books b ON b.accession_no=bi.accession_no
Inner Join titles t ON t.title_id=b.title_id
where (bi.member_id,bi.accession_no,bi.issue_dt) NOT IN
(select (br.member_id,br.accession_no,br.issue_dt) from book_return br);

/*Write a SELECT command to display information on the books
that have been returned after their due dates. The information
should include book issue date, title, member name and due
date.*/
select b.accession_no, bi.issue_dt,t.title_nm,m.member_nm,bi.due_dt
from book_issue bi
Inner Join members m ON m.member_id=bi.member_id
Inner Join books b ON b.accession_no=bi.accession_no
Inner Join titles t ON t.title_id=b.title_id
where bi.due_dt < (select br.return_dt from book_return br);

/*Write a SELECT command to display information of those books
whose price is equal to the most expensive book purchase so far.*/
select accession_no, title_id, purchase_dt,price, status from books 
where price = (select MAX(price) from books);

/*Write a SELECT command to display the second maximum price
of a book.*/
select MAX(price) from books 
where price!= (select MAX(price) from books);
