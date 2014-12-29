package repositories.impl.dummy;

import java.util.ArrayList; 
import java.util.List;

import domain.Address;
import domain.Client;
import domain.User;
import domain.Car;
import repositories.*;

public class DummyClientRepository implements IClientRepository{

	private DummyDb db;
	
	public DummyClientRepository(DummyDb db) {
		this.db = db;
	}

	@Override
	public void save(Client entity) {
		db.clients.add(entity);
		
	}

	@Override
	public void update(Client entity) {
		
	}

	@Override
	public void delete(Client entity) {
		db.clients.remove(entity);
		
	}

	@Override
	public Client get(int id) {
		for(Client c:db.clients)
		{
			if(c.getId()==id)
				return c;
		}
		return null;
	}

	@Override
	public List<Client> getAll() {
		return db.clients;
	}

	

	/**/
	
	
	
	@Override
	public Client byUser(User user) {
		return byUser (user.getId());
	}

	@Override
	public Client byUser(String login, String password) {
		
		for(User u:db.users)
		{
			if((u.getLogin()==login) && (u.getPassword()==password))
				return u.getClient();
		}
		return null;
	}

	@Override
	public Client byUser(int userId) {
		
		for(User u:db.users)
		{
			if(u.getId()==userId)
				return u.getClient();
		}
		return null;
	}

	@Override
	public Client byAddress(Address address) {
		return byAddress(address.getId());
	}

	@Override
	public Client byAddress(String country, String city, String postCode,
			String street, String number) {
		
		for(Address a:db.addresses)
		{
			if((a.getCountry()==country) && (a.getCity()==city) && (a.getPostCode()==postCode) && (a.getStreet()==street) && (a.getNumber()==number))
				return a.getClient();
		}
		return null;
	}

	@Override
	public Client byAddress(int addressId) {
		
		for(Address a:db.addresses)
		{
			if(a.getId()==addressId)
				return a.getClient();
		}
		return null;
	}

	public List<Client> ofCar(Car car) {
		return ofCar(car.getId());
	}

	@Override
	public List<Client> ofCar(String make, String model, int year,
			double mileage, String fuelType, int engine) {

		for(Car ca:db.cars)
		{
			if((ca.getMake()==make) && (ca.getModel()==model) && (ca.getYear()==year) && (ca.getMileage()==mileage) && (ca.getFuelType()==fuelType) && (ca.getEngine()==engine))
				return ca.getClients();
		}
		return new ArrayList<Client>();
	}

	@Override
	public List<Client> ofCar(int carId) {
		
		for(Car ca:db.cars)
		{
			if(ca.getId()==carId)
				return ca.getClients();
		}
		return new ArrayList<Client>();
	}
}
