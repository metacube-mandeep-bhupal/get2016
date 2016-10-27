package model;

public class CarValueObject implements VehicleValueObject {
	private int ID;
	private String company;
	private String model;
	private double engineInCC;
	private double fuelCapacity;
	private double mileage;
	private double price ;
	private double roadTax;
	
	private int isPowerSteering;
	private int isAccessoryKit;
	private int isAC; 
	
	public int getIsPowerSteering() {
		return isPowerSteering;
	}

	public void setPowerSteering(int isPowerSteering) {
		this.isPowerSteering = isPowerSteering;
	}

	public int getIsAccessoryKit() {
		return isAccessoryKit;
	}

	public void setAccessoryKit(int isAccessoryKit) {
		this.isAccessoryKit = isAccessoryKit;
	}

	public int  getIsAC() {
		return isAC;
	}

	public void setAC(int isAC) {
		this.isAC = isAC;
	}

	@Override
	public Double calculateOnRoadPrice() {
		return (this.roadTax+this.price);
	}

	@Override
	public void setCompany(String s) {
		this.company = s;		
	}

	@Override
	public void setModel(String s) {
		this.model = s;
	}

	@Override
	public void setEngineInCC(double d) {
		this.engineInCC = d;		
	}

	@Override
	public void setFuelCapacity(double d) {
		this.fuelCapacity = d;
	}

	@Override
	public void setMileage(double d) {
		this.mileage = d;
	}

	@Override
	public void setPrice(double d) {
		this.price = d;
	}

	@Override
	public void setRoadTax(double d) {
		this.roadTax = d;	
	}

	@Override
	public String getComapny() {
		return this.company;
	}

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public double getEngineInCC() {
		return this.engineInCC;
	}

	@Override
	public double getFuelCapacity() {
		return this.fuelCapacity;
	}

	@Override
	public double getMileage() {
		return this.mileage;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public double getRoadTax() {
		return this.roadTax;
	}

	@Override
	public void setID(int id) {
		this.ID = id;
		
	}

	@Override
	public int getID() {
		return this.ID;
	}
}