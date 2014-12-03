package repositories.dummy;

import java.util.ArrayList; 
import java.util.List;

import domain.*;

public class DummyDb {
	
	public List<Service> services;
	public List<Client> clients;
	public List<Car> cars;
	public List<User> users;
	public List<Address> addresses;
	
	public DummyDb()
	{
		services = new ArrayList<Service>();
		clients = new ArrayList<Client>();
		cars = new ArrayList<Car>();
		users = new ArrayList<User>();
		addresses = new ArrayList<Address>();
	}

}
