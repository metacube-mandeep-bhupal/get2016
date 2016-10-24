package session8.assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SotingSystemTestUnit {

	@Test
	public void test() {
		int array1[] = {12,456,9999,684,32,5123,55,67,258,61,100};
		int array2[] = {23,56,45,23,12,56,45,23};
		int expected1[] = {12,32,55,61,67,100,258,456,684,5123,9999};
		int expected2[] = {12,23,23,23,45,45,56,56};
		
		LinearSorting objOflinearSort1 = new LinearSorting(array1);
		ComparisonSorting objOfComparisonSort1 = new ComparisonSorting(array1);
		LinearSorting objOflinearSort2 = new LinearSorting(array2);
		ComparisonSorting objOfComparisonSort2 = new ComparisonSorting(array2);
		
		assertArrayEquals(expected1,objOflinearSort1.linearSort());
		assertArrayEquals(expected2,objOflinearSort2.linearSort());
		assertArrayEquals(expected1,objOfComparisonSort1.comparison());
		assertArrayEquals(expected2,objOfComparisonSort2.comparison());
	}

}
