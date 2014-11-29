package repositories;

import java.util.List;

import domain.*;

public interface IServiceRepository extends IRepository<Service> {

	public List <Service> ofCar(Car car);
	public List <Service> ofCar(String make, String model, int year,
			double mileage, String fuelType, int engine);
	public List <Service> ofCar(int carId);

}