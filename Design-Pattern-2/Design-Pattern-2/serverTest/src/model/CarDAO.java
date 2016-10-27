package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
	public boolean insertCars(CarValueObject carValueObject) throws ClassNotFoundException, SQLException, IOException{
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection con = cf.getConnection();
		PreparedStatement preparedStatement;
		String query;
		query = "INSERT INTO `car_detail` "
				+ "(`company`,`model`,`engineInCC`,`fuelCapacity`,`milage`,`price`,"
				+ "`roadTax`,"
				+ "`isPowerSteering`,`isAccessoryKit`,`isAC`) VALUES (? , ? , ? , ? , ? , ? , ? , ? , ? , ?); ";
		
		boolean flag;
		flag = false;
		try{
			if(con != null){
				preparedStatement =  con.prepareStatement(query);
				if(preparedStatement != null){
					preparedStatement.setString(1, carValueObject.getComapny());
					preparedStatement.setString(2, carValueObject.getModel());
					preparedStatement.setDouble(3, carValueObject.getEngineInCC());
					preparedStatement.setDouble(4, carValueObject.getFuelCapacity());
					preparedStatement.setDouble(5, carValueObject.getMileage());
					preparedStatement.setDouble(6, carValueObject.getPrice());
					preparedStatement.setDouble(7, carValueObject.getRoadTax());
					preparedStatement.setInt(8, carValueObject.getIsPowerSteering());
					preparedStatement.setInt(9, carValueObject.getIsAccessoryKit());
					preparedStatement.setInt(10, carValueObject.getIsAC());
					preparedStatement.executeUpdate();
					flag = true;
				}
			}
		}catch(Exception e){
			// how to handle it???
			e.printStackTrace();
		}
		
		return flag;	
	}
 
	public List<CarValueObject> getCars() throws ClassNotFoundException, SQLException, IOException{
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection con = cf.getConnection();
		PreparedStatement preparedStatement;
		String query;
		List<CarValueObject> carList = new ArrayList<CarValueObject>();
		query = "SELECT * FROM `car_detail` "; 
		try{
			if(con != null){
				preparedStatement =  con.prepareStatement(query);
				if(preparedStatement != null){
					ResultSet resultSet =  preparedStatement.executeQuery();
					
					while(resultSet.next()){
						CarValueObject carValueObject = new CarValueObject();
						carValueObject.setID(resultSet.getInt(1));
						carValueObject.setCompany(resultSet.getString(2));
						carValueObject.setModel(resultSet.getString(3));
						carValueObject.setEngineInCC(resultSet.getDouble(4));
						carValueObject.setFuelCapacity(resultSet.getDouble(5));
						carValueObject.setPrice(resultSet.getDouble(7));
						carValueObject.setRoadTax(resultSet.getDouble(8));
						carValueObject.setMileage(resultSet.getDouble(6));
						carValueObject.setPowerSteering(resultSet.getInt(9));
						carValueObject.setAccessoryKit(resultSet.getInt(10));
						carValueObject.setAC(resultSet.getInt(11));
						carList.add(carValueObject);
					}
				}
			}
		}catch(Exception e){
			// how to handle it???
			e.printStackTrace();
		}
		
		return carList;	
	}

	public boolean updateCar(CarValueObject carValueObject) throws ClassNotFoundException, SQLException, IOException{
		
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection con = cf.getConnection();
		PreparedStatement preparedStatement;
		String query;
		query = "UPDATE `car_detail` SET `company` = ? , `model` = ? ,`engineInCC` = ?, "
				+ "`fuelCapacity` = ?,`milage` = ?,`price` = ?, `roadTax` = ?,"
				+ "`isPowerSteering` = ? ,`isAccessoryKit` = ?,`isAC` = ? where `id` = ? ;";

		
		boolean flag;
		flag = false;
		try{
			if(con != null){
				preparedStatement =  con.prepareStatement(query);
				if(preparedStatement != null){
					preparedStatement.setString(1, carValueObject.getComapny());
					preparedStatement.setString(2, carValueObject.getModel());
					preparedStatement.setDouble(3, carValueObject.getEngineInCC());
					preparedStatement.setDouble(4, carValueObject.getFuelCapacity());
					preparedStatement.setDouble(5, carValueObject.getMileage());
					preparedStatement.setDouble(6, carValueObject.getPrice());
					preparedStatement.setDouble(7, carValueObject.getRoadTax());
					preparedStatement.setInt(8, carValueObject.getIsPowerSteering());
					preparedStatement.setInt(9, carValueObject.getIsAccessoryKit());
					preparedStatement.setInt(10, carValueObject.getIsAC());
					preparedStatement.setInt(11, carValueObject.getID());
					preparedStatement.executeUpdate();
					flag = true;
				}
			}
		}catch(Exception e){
			// how to handle it???
			e.printStackTrace();
		}
		
		return flag;	
	}

}
