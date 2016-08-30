package assignment1;

import java.util.List;

public class Driver {

	public static void main(String[] args) {
		DataHandlerClass dh=new DataHandlerClass();
		
		//task-1 books by author name
		String authorName="Bipul Jain";
		List<Book> books=dh.fetchBooks(authorName);
		System.out.println(books);
		
		//task-2 number of available book to be issued 
		String title="Make It Happen";
		
		int totalbooks=dh.getNumberOfTotalBooks(title);
		int nonAvailableCount=dh.getNumberOfNonAvailableBooks(title);
		
		System.out.println("\n"+totalbooks+" Total books are there having title " + title);
		System.out.println("\n"+nonAvailableCount+" not issued");
		
		//task-3 deleting books not issued for one year 
		int numOfDeletedBooks=dh.deleteBooks();
		System.out.println( numOfDeletedBooks +" Books deleted" );
	}

}
