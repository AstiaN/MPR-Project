package repositories;

import java.util.List;

import domain.*;

public interface IClientRepository extends IRepository<Client> {

	public Client byUser(User user);
	public Client byUser(String login, String password);
	public Client byUser(int userId);

	public Client byAddress(Address address);
	public Client byAddress(String country, String city, String postCode,
			String street, String number);
	public Client byAddress(int addressId);

	public List <Client> ofCar(Car car);
	public List <Client> ofCar(String make, String model, int year,
			double mileage, String fuelType, int engine);
	public List <Client> ofCar(int carId);
}