package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
*Following class Facade interacts with CarDAO and controller and acts as a transfer object.
*/
public class CarFacade {

	/**
	*Following function transfer the details of car from controller to the CarDAO for the insertion of new car details(Dao manager)
	*returns true/false whether the details of car are passed successfully or not.
	*/
	public boolean insertCar(CarValueObject car) throws ClassNotFoundException, SQLException, IOException{
		CarDAO carDAO = new CarDAO();
		return carDAO.insertCars(car);
	}

	/**
	*Following function transfer the details of all cars from carDAO to the controller(Dao manager)
	*returns the list of cars which all are existing in car database.
	*/
	public List<CarValueObject> getCars() throws ClassNotFoundException, SQLException, IOException{
		CarDAO carDAO = new CarDAO();
		return carDAO.getCars();
	}

	/**
	*Following function transfer the details of car from controller to the CarDAO(Dao manager) for the updation of details of the existing car.
	*returns true/false whether the details of car are updated successfully or not.
	*/
	public boolean updateCar(CarValueObject carValueObject) throws ClassNotFoundException, SQLException, IOException{
		CarDAO carDAO = new CarDAO();
		return carDAO.updateCar(carValueObject);
	}

}
