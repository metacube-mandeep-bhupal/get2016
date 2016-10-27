package restServer;

import java.util.List;

import model.Employee;

import com.google.gson.Gson;


public class DataTransformer {

	public static String convertToJson(List<Employee> listOfEmployee){

		String employeesInJson = null;
		Gson gson = null;

		try{
			
			gson =  new Gson();
			
			employeesInJson = gson.toJson(listOfEmployee);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return employeesInJson;
	}
}