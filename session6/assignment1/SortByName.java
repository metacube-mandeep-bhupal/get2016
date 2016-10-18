package session6.assignment1;

import java.util.Comparator;

public class SortByName implements Comparator<Employee> {

	/**
	 * Following function compares the names of employees alphabetically and
	 * returns the appropriate result. employee1(Employee) denotes the 1st
	 * employee. employee2(Employee) denotes the 2nd employee.
	 */
	public int compare(Employee employee1, Employee employee2) {

		return employee1.getName().toLowerCase()
				.compareTo(employee2.getName().toLowerCase());
	}

}
