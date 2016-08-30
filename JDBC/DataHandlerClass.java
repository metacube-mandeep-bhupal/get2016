package assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;



public class DataHandlerClass {

	Connection con;
	Statement st;
	
	static final String DB_URL="jdbc:mysql://localhost/library";
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	
	public DataHandlerClass()
	{
		try{
			Class.forName(this.JDBC_DRIVER);
			con=DriverManager.getConnection(DB_URL,"root","mandeep");
			st=con.createStatement();
			
		}catch(ClassNotFoundException cnfe)
		{
			System.out.println("error loading the driver");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/*Task 1: Fetch all the books published by author, given the name of the author. 
Return the books data (List of Titles).*/
	public List<Book> fetchBooks(String authorname){
		
		ResultSet rs;
		List<Book> books= new LinkedList<Book>();
		String query="Select t.title_nm from titles t"
				+" Inner Join title_author ta ON ta.title_id=t.title_id"
				+" where ta.author_id=(Select author_id from authors where author_nm LIKE '"+authorname+"')";
		System.out.println(query);
		
		try{
			rs=st.executeQuery(query);
			while(rs.next())
			{
				Book b=new Book();
				b.setName(rs.getString(1));
				books.add(b);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return books;
		
	}
	/*Task 2: Given the name of the book, to be issued by an existing member.
	 Return flag to indicate whether the book has been issued or not.*/
	public int getNumberOfNonAvailableBooks(String title){
		return getNumberOfBooksIssued(title)-getNumberOfBooksReturned(title);
	}
	
	
	public int getNumberOfTotalBooks(String title){
		
		int ret;
		ResultSet rs;
		String query="Select COUNT(accession_no) from books"
				+" where accession_no IN (Select accession_no from books"
				+" where title_id = (Select title_id from titles where title_nm LIKE '"+title+"'))";
		
		try{
			rs=st.executeQuery(query);
			if(rs.next())
			{
				 return rs.getInt(1);
			}
			else{
				return 0;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
		
	}
	
	
	public int getNumberOfBooksIssued(String title){
		
		ResultSet rs;
		String query="Select accession_no from book_issue"
				+" where accession_no IN (Select accession_no from books"
				+" where title_id = (Select title_id from titles where title_nm LIKE '"+title+"'))";
		System.out.println(query);
		
		try{
			rs=st.executeQuery(query);
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
				return 0;
		}catch(SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
		
			
	}
	
	
	public int getNumberOfBooksReturned(String title){
		ResultSet rs;
		
		String query="Select accession_no from book_return"
				+" where accession_no IN (Select accession_no from books"
				+" where title_id=(Select title_id from titles where title_nm LIKE '"+title+"'))";
		
		System.out.println(query);
		
		try{
			rs=st.executeQuery(query);
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
				return 0;
		}catch(SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
		
	}
	
	
	/*this method returns false if book not issued else true*/
	public boolean bookIssuedOrNot(String title)
	{
		if(getNumberOfNonAvailableBooks(title)==0)
			return false;
		else
			return true;
	}
	
	/*Task 3: Delete all those books which were not issued in last 1 year. Return the number of books deleted.*/
	public int deleteBooks(){
		ResultSet rs;
		
		String query="Delete from books where accession_number NOT IN "
					+" (Select accession_number from book_issue where TIMESTAMPDIFF(MONTH,NOW(),issue_dt) < 12 )";
		try 
		{
			return st.executeUpdate(query);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
	}
	
	
}
