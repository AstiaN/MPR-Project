package repositories.impl.Dummy;

import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.*;

public class DummyServiceRepository implements IServiceRepository{

	private DummyDb db;
	
	public DummyServiceRepository(DummyDb db) {
		this.db = db;
	}

	@Override
	public void save(Service entity) {
		db.services.add(entity);
		
	}

	@Override
	public void update(Service entity) {
		
	}

	@Override
	public void delete(Service entity) {
		db.services.remove(entity);
		
	}

	@Override
	public Service get(int id) {
		
		for(Service s:db.services)
		{
			if(s.getId()==id)
				return s;
		}
		return null;
	}

	@Override
	public List<Service> getAll() {
		return db.services;
	}

	/* */
	
	@Override
	public List<Service> ofCar(Car car) {
		return ofCar(car.getId());
	}

	@Override
	public List<Service> ofCar(String make, String model, int year,
			double mileage, String fuelType, int engine) {

		for(Car ca:db.cars)
		{
			if((ca.getMake()==make) && (ca.getModel()==model) && (ca.getYear()==year) && (ca.getMileage()==mileage) && (ca.getFuelType()==fuelType) && (ca.getEngine()==engine))
				return ca.getServices();
		}
		return new ArrayList<Service>();
	}

	@Override
	public List<Service> ofCar(int carId) {
		
		for(Car ca:db.cars)
		{
			if(ca.getId()==carId)
				return ca.getServices();
		}
		return new ArrayList<Service>();
	}
}
