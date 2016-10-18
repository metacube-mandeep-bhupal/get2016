package session6.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MainClassEmployee {

	private HashMap<String, Employee> employees; // declares the Hashmap which
													// stores Employee Id as
													// keys and employee details
													// as value.
	private List<Employee> employeesDetails; // declares the list of Employee.

	/**
	 * Constructor to initialize the member variables.
	 */
	public MainClassEmployee() {
		employees = new HashMap<String, Employee>();
		employeesDetails = new ArrayList<Employee>();
	}

	/**
	 * Following function asks the user to enter the details of the employees.  
	 * @return List(Employee) returns the List of Employees whose details have
	 * been entered.
	 */
	public List<Employee> employeeDetails() {
		String iD = "";
		String name = "";
		String address = "";
		Scanner sc = new Scanner(System.in);
		do {

			do {
				System.out.println("Enter ID  :");
				iD = sc.nextLine();
				if (employees.containsKey(iD.toLowerCase())) {
					System.out.println("\nEmployee Already Exists ");
					continue;
				}
				System.out.println("Enter Name  :");
				name = sc.nextLine();

				System.out.println("Enter address  :");
				address = sc.nextLine();
			} while (employees.containsKey(iD.toLowerCase()));

			employeesDetails.add(new Employee(iD, name, address));

			employees.put(iD.toLowerCase(),
					employeesDetails.get(employeesDetails.size() - 1));

			System.out.println("Enter y for continue : ");

		} while (sc.nextLine().equalsIgnoreCase("y"));

		sc.close();
		return employeesDetails;
	}

	/**
	 * Driver test main() function to test the program
	 * @param args[](String) denotes the Command line Arguments
	 */
	public static void main(String args[]) {

		List<Employee> employee = new ArrayList<Employee>();
		MainClassEmployee obj = new MainClassEmployee();

		employee = obj.employeeDetails();
		System.out.println("Natural Order Sorting : \n");
		Collections.sort(employee);
		System.out.println(employee);

		System.out.println("\n\nSorting based on Name : \n");
		Collections.sort(employee, new SortByName());
		System.out.println(employee);
	}
}
