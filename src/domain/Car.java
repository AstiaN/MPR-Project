package domain;

import java.util.ArrayList;
import java.util.List;

public class Car extends Entity{

	public Car() {
		super();
		this.services = new ArrayList<Service>();
		this.clients = new ArrayList<Client>();
	}
	
	private String make;
	private String model;
	private int year;
	private double mileage;
	private String fuelType;
	private int engine;
	
	private List <Client> clients;
	private List <Service> services;
	
	/* */
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	public int getEngine() {
		return engine;
	}
	public void setEngine(int engine) {
		this.engine = engine;
	}
	
	/* */
	
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	
}
