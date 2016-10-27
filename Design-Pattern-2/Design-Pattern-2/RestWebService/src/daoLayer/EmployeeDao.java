package daoLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

/**
 * @author admin
 *
 */
public class EmployeeDao {

	private Connection connection;

	public EmployeeDao(Connection connection){

		this.connection = connection;
	}

	public int addEmployee(Employee employee){

		String sqlQuery = "INSERT INTO employeeinfo (ID,EmployeeName,EmployeeAge) "
				+ "Values (? , ? , ? );";

		int result = 0;
		List<Employee> employeeList = null;
		PreparedStatement prepareStatement = null;
		try{
			employeeList = selectEmployeeBasedOnID(employee.getId());

			if(employeeList.size() != 0){

				result = 1;
			}
			
			else{
				if(this.connection != null){
					prepareStatement = this.connection.prepareStatement(sqlQuery);
				}
				if(prepareStatement != null){

					prepareStatement.setString(1, employee.getId());
					prepareStatement.setString(2, employee.getName());
					prepareStatement.setInt(3, employee.getAge());

					prepareStatement.executeUpdate();

					result = 2;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return result;
	}

	public List<Employee> selectEmployeeBasedOnID(String employeeID){
		
		String sqlQuery = "SELECT ID,EmployeeName,EmployeeAge FROM employeeinfo "
				+ "WHERE ID = ?;";

		PreparedStatement prepareStatement = null;

		List<Employee> listOfEmployee = null;

		try{

			listOfEmployee = new ArrayList<Employee>();

			if(this.connection != null){

				prepareStatement = this.connection.prepareStatement(sqlQuery);

			}
			if(prepareStatement != null){

				prepareStatement.setString(1, employeeID);

				ResultSet resultSet = prepareStatement.executeQuery();
				
				if(resultSet != null){

					while(resultSet.next()){

						Employee employee = new Employee();
						employee.setId(resultSet.getString(1));
						employee.setName(resultSet.getString(2));
						employee.setAge(resultSet.getInt(3));
						listOfEmployee.add(employee);
					}

				} 
			}

		}catch(Exception ex){

			ex.printStackTrace();
		}
		
		return listOfEmployee;

	}

	public List<Employee> selectEmployeeBasedOnName(String employeeName){

		String sqlQuery = "SELECT ID,EmployeeName,EmployeeAge FROM employeeinfo "
				+ "WHERE EmployeeName = ?;";

		PreparedStatement prepareStatement = null;

		List<Employee> listOfEmployee = null;

		try{

			listOfEmployee = new ArrayList<Employee>();

			if(this.connection != null){

				prepareStatement = this.connection.prepareStatement(sqlQuery);

			}
			if(prepareStatement != null){

				prepareStatement.setString(1, employeeName);

				ResultSet resultSet = prepareStatement.executeQuery();

				if(resultSet != null){

					while(resultSet.next()){

						Employee employee = new Employee();
						employee.setId(resultSet.getString(1));
						employee.setName(resultSet.getString(2));
						employee.setAge(resultSet.getInt(3));
						listOfEmployee.add(employee);
					}

				} 
			}

		}catch(Exception ex){

			ex.printStackTrace();
		}

		return listOfEmployee;

	}

	public List<Employee> selectAllEmployee(){

		String sqlQuery = "SELECT ID,EmployeeName,EmployeeAge FROM employeeinfo;";

		PreparedStatement prepareStatement = null;

		List<Employee> listOfEmployee = null;

		try{

			listOfEmployee = new ArrayList<Employee>();

			if(this.connection != null){

				prepareStatement = this.connection.prepareStatement(sqlQuery);

			}
			if(prepareStatement != null){

				ResultSet resultSet = prepareStatement.executeQuery();

				if(resultSet != null){    

					while(resultSet.next()){

						Employee employee = new Employee();
						employee.setId(resultSet.getString(1));
						employee.setName(resultSet.getString(2));
						employee.setAge(resultSet.getInt(3));
						listOfEmployee.add(employee);
					}

				} 
			}

		}catch(Exception ex){

			ex.printStackTrace();
		}

		return listOfEmployee;

	}

	public int deleteEmployee(String employeeID){

		List<Employee> employeeList = null;

		String sqlQuery = "DELETE FROM employeeinfo WHERE ID = ?;";

		int result = 0;

		PreparedStatement prepareStatement = null;
		try{

			employeeList = selectEmployeeBasedOnID(employeeID);

			if(employeeList.size() == 0){

				result = 1;
			}

			else{

				if(this.connection != null){
					prepareStatement = this.connection.prepareStatement(sqlQuery);
				}
				if(prepareStatement != null){

					prepareStatement.setString(1, employeeID);

					prepareStatement.executeUpdate();

					result = 2;
				}
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}

		return result;
	}
}