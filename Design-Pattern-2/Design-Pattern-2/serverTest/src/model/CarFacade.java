package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CarFacade {
	public boolean insertCar(CarValueObject car) throws ClassNotFoundException, SQLException, IOException{
		CarDAO carDAO = new CarDAO();
		return carDAO.insertCars(car);
	}
	public List<CarValueObject> getCars() throws ClassNotFoundException, SQLException, IOException{
		CarDAO carDAO = new CarDAO();
		return carDAO.getCars();
	}
	public boolean updateCar(CarValueObject carValueObject) throws ClassNotFoundException, SQLException, IOException{
		CarDAO carDAO = new CarDAO();
		return carDAO.updateCar(carValueObject);
	}

}
