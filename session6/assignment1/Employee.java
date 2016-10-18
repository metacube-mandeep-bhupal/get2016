package session6.assignment1;

public class Employee implements Comparable<Employee> {

	private String employeeID; // declared employeeId of type String
	private String name; // declared name of type String
	private String address; // declared address of type String

	/**
	 * Constructor To initialize the Employee Class member variables
	 * @param employeeID(String) denotes the employee Id given by the user
	 * @param name(String) denotes the name of the employee.
	 * @param address(String) denotes the address of the employee
	 */
	public Employee(String employeeID, String name, String address) {
		this.employeeID = employeeID;
		this.name = name;
		this.address = address;
	}

	/**
	 * Following function returns the employee Id
	 */
	public String getEmployeeID() {
		return employeeID;
	}

	/**
	 * Following function sets the employee Id
	 */
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * Following function returns the employee name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Following function sets the employee name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Following function returns the employee address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Following function sets the employee address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Following function compares the employee ID. It is used in natural order
	 * sorting
	 */
	public int compareTo(Employee employee) {
		return getEmployeeID().compareTo(employee.getEmployeeID());
	}
