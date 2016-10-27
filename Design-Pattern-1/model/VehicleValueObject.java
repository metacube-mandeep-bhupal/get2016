package model;

public interface VehicleValueObject {

	public  Double calculateOnRoadPrice();
	// setter method 
		
	  void setCompany(String s);
	  void setModel(String s);
	  void setEngineInCC(double d);
	  void setFuelCapacity(double d);
	  void setMileage(double d);
	  void setPrice(double d);
	  void setRoadTax(double d);
	  void setID(int id);
	// getter method
	  int getID();
	  String getComapny();
	  String getModel();
	  double getEngineInCC();
	  double getFuelCapacity();
	  double getMileage();
	  double getPrice();
	  double getRoadTax();
	
}
