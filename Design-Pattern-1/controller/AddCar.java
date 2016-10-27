package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarFacade;
import model.CarValueObject;

/**
 * Servlet implementation class IndexCar
 */
@WebServlet("/IndexCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCar() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter out = response.getWriter()){
		String companyName = request.getParameter("companyName");
		String model = request.getParameter("Model");
		String fuelCapacity = request.getParameter("FuelCapacity");
		String milage = request.getParameter("milage");
		String price = request.getParameter("price");
		String roadTax = request.getParameter("RoadTax");
		String airConditioner = request.getParameter("AC");
		String powerStreering = request.getParameter("PowerStreering");
		String accessoryKit = request.getParameter("AccessoryKit");
		String engineInCC = request.getParameter("EngineInCC");
		// set values in POJO
		CarValueObject carValueObject = new CarValueObject();
		carValueObject.setCompany(companyName);
		carValueObject.setModel(model);
		carValueObject.setEngineInCC(Double.parseDouble(engineInCC));
		carValueObject.setFuelCapacity(Double.parseDouble(fuelCapacity));
		carValueObject.setPrice(Double.parseDouble(price));
		carValueObject.setRoadTax(Double.parseDouble(roadTax));
		carValueObject.setMileage(Double.parseDouble(milage));
		if(powerStreering.equals("Yes")){	
			carValueObject.setPowerSteering(1);
		}
		else{
			carValueObject.setPowerSteering(0);
		}
		if(airConditioner.equals("Yes")){
			carValueObject.setAC(1);
		}else{
			System.out.println("air is 0");
			carValueObject.setAC(0);
		}
		if(accessoryKit.equals("Yes")){
			carValueObject.setAccessoryKit(1);
		}else{
			carValueObject.setAccessoryKit(0);
		}
		CarFacade carFacade =  new CarFacade();
		try {
			boolean flag = carFacade.insertCar(carValueObject);
			if(flag == true){
				out.println("Data Inserted");
			}else{
				out.println("Sorry,Someyhing goes wrong");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
