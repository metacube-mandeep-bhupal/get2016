package model;

import java.util.List;

import daoLayer.EmployeeDao;
import daoLayer.ConnectionFactory;

public class EmployeeFacade {

	public List<Employee> selectAllEmployees(){

		ConnectionFactory connectionFactory = null;

		List<Employee> employeeList = null;

		try{

			connectionFactory = ConnectionFactory.getInstance();

			EmployeeDao employeedao = new EmployeeDao(connectionFactory.getConnection());

			employeeList = employeedao.selectAllEmployee();
		}catch(Exception ex){

			ex.printStackTrace();
		}finally{
			try{
				connectionFactory.closeConnection();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

		return employeeList;
	}

	public int addEmployees(Employee employee){

		ConnectionFactory connectionFactory = null;
		int result = 0;

		try{

			connectionFactory = ConnectionFactory.getInstance();

			EmployeeDao employeedao = new EmployeeDao(connectionFactory.getConnection());

			result = employeedao.addEmployee(employee);
			
		}catch(Exception ex){

			ex.printStackTrace();
		}

		return result;
	}

	public List<Employee> selectEmployeeBasedOnId(String employeeID){

		ConnectionFactory connectionFactory = null;

		List<Employee> employeeList = null;

		try{

			connectionFactory = ConnectionFactory.getInstance();

			EmployeeDao employeedao = new EmployeeDao(connectionFactory.getConnection());

			employeeList = employeedao.selectEmployeeBasedOnID(employeeID);
		}catch(Exception ex){

			ex.printStackTrace();
		}finally{
			try{
				connectionFactory.closeConnection();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

		return employeeList;
	}

	public List<Employee> selectEmployeeBasedOnName(String employeeName){

		ConnectionFactory connectionFactory = null;

		List<Employee> employeeList = null;

		try{

			connectionFactory = ConnectionFactory.getInstance();

			EmployeeDao employeedao = new EmployeeDao(connectionFactory.getConnection());

			employeeList = employeedao.selectEmployeeBasedOnName(employeeName);
		}catch(Exception ex){

			ex.printStackTrace();
		}finally{
			try{
				connectionFactory.closeConnection();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

		return employeeList;
	}

	public int deleteEmployeeBasedOnId(String employeeID){

		ConnectionFactory connectionFactory = null;
		int result = 0;

		try{

			connectionFactory = ConnectionFactory.getInstance();

			EmployeeDao employeedao = new EmployeeDao(connectionFactory.getConnection());

			result = employeedao.deleteEmployee(employeeID);

		}catch(Exception ex){

			ex.printStackTrace();
		}

		return result;
	}
}