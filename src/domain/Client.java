package domain;

import java.util.ArrayList;
import java.util.List;

public class Client extends Entity{
	
	public Client() {
		super();
		this.addresses = new ArrayList<Address>();
		this.users = new ArrayList<User>();
		this.cars = new ArrayList<Car>();
	}

	private String firstName;
	private String surname;
	private String pesel;
	private String email;
	private double phoneNumber;
	
	private List<Address> addresses;
	private List<Car> cars;
	private List<User> users;
	
	/* */
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/* */
	
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
