USE library;

/*Create a View which can be used to display member name and
all issue details of the member using a simple SELECT command.*/
Create View member_issue 
AS
select m.member_nm, bi.issue_dt,bi.accession_no,bi.member_id, bi.due_dt 
from book_issue bi
Left Join members m ON m.member_id=bi.member_id;

select member_nm,issue_dt,accession_no,member_id,due_dt from member_issue
where member_id='101';

/*Create a View which contains three columns, member name,
member id and full description of category, i.e., Faculty, Students
and Others instead of F,S and O*/
Create View member_category
AS
select member_id,member_nm,
CASE category
   when 'F' then 'Faculty'
   when 'S' then 'Student'
   else 'Others'
END AS category from members;   


/*Create a View which contains the information – subject name,
title, member name, category, issue date, due date and return
date. If the books have not been returned, NULL should be
displayed instead of return date.*/
Create View information 
AS
select s.subject_nm,t.title_nm, m.member_nm,m.category,bi.issue_st,bi.due_dt,br.return_dt
from book_issue bi
Left Join members m ON m.member_id=bi.member_id
Left Join book_return br ON br.accession_no=bi.accession_no AND br.member_id=bi.member_id AND br.issue_dt=bi.issue_dt
Left Join books b ON b.accession_no=bi.accession_no
Left Join titles t ON t.title_id=b.title_id
Left Join subjects s ON s.subject_id=t.subject_id;
