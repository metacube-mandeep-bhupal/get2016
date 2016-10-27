package restServer;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import model.Employee;
import model.EmployeeFacade;

@Path("/EmployeeService")
public class EmployeeService {

	@GET
	@Path("/getAllEmployees")
	@Produces("application/json")
	public String getAllEmployees(){

		String employees = null;
		List<Employee> employeeList = null;
		EmployeeFacade facade = null;
		try{
			facade = new EmployeeFacade();
			employeeList = facade.selectAllEmployees();
			employees = DataTransformer.convertToJson(employeeList);
		}catch(Exception ex){

			ex.printStackTrace();
		}
		return employees;
	}


	@POST
	@Path("/addEmployee")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String addEmployee(String jsonStr){

		String resultString = "Employee Not Added . Something went wrong";
		EmployeeFacade facade = null;
		int result = 0;
		try{
			Gson gson = new Gson();
			JsonElement element = gson.fromJson(jsonStr, JsonElement.class);
			JsonObject jsonObject = element.getAsJsonObject();
			String employeeID = jsonObject.get("id").getAsString();
			String employeeName = jsonObject.get("name").getAsString();
			int employeeAge = Integer.parseInt(jsonObject.get("age").toString());
			facade = new EmployeeFacade();
			Employee employee = new Employee();
			employee.setId(employeeID);
			employee.setName(employeeName);
			employee.setAge(employeeAge);
			result = facade.addEmployees(employee);
			if(result == 2){

				resultString = "Employee Added Successfully";
			}else if(result == 1){
				
				resultString = "Employee Already Present";
			}
		}catch(Exception ex){

			ex.printStackTrace();
		}
		return resultString;
	}

	@POST
	@Path("/getEmployeeById")
	@Produces("application/json")
	@Consumes(MediaType.TEXT_PLAIN)
	public String getEmployeeById(String ID){

		ID = ID.trim();
		String employees = "Employee Not Present";
		List<Employee> employeeList = null;
		EmployeeFacade facade = null;
		try{
			facade = new EmployeeFacade();
			employeeList = facade.selectEmployeeBasedOnId(ID);
			if(employeeList.size() != 0){
				employees = DataTransformer.convertToJson(employeeList);
			}
		}catch(Exception ex){

			ex.printStackTrace();
		}
		return employees;
	}


	@POST
	@Path("/getEmployeeByName")
	@Produces("application/json")
	@Consumes(MediaType.TEXT_PLAIN)
	public String getEmployeeByName(String employeeName){
		
		employeeName = employeeName.trim();
		String employees = "Employee Not Present";
		List<Employee> employeeList = null;
		EmployeeFacade facade = null;
		try{

			facade = new EmployeeFacade();
			employeeList = facade.selectEmployeeBasedOnName(employeeName);
			if(employeeList.size() != 0){
				employees = DataTransformer.convertToJson(employeeList);
			}
		}catch(Exception ex){

			ex.printStackTrace();
		}
		return employees;
	}

	@POST
	@Path("/deleteEmployeeById")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String deleteEmployeeById(String employeeID){

		employeeID = employeeID.trim();
		String resultString = "Employee Not Deleted.Something went wrong";
		EmployeeFacade facade = null;
		int result = 0;
		try{
			facade = new EmployeeFacade();
			
			result = facade.deleteEmployeeBasedOnId(employeeID);
			
			if(result == 2){

				resultString = "Employee Deleted Successfully";
			}else if(result == 1){
				resultString = "Employee Not Present";
			}
		}catch(Exception ex){

			ex.printStackTrace();
		}
		return resultString;
	}
}