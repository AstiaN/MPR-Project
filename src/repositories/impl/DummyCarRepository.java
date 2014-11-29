package repositories.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.*;
import repositories.*;

public class DummyCarRepository implements ICarRepository{

	private DummyDb db;

	public DummyCarRepository(DummyDb db) {
		this.db = db;
	}
	
	@Override
	public void save(Car entity) {
		db.cars.add(entity);
		
	}

	@Override
	public void update(Car entity) {
		
	}

	@Override
	public void delete(Car entity) {
		db.cars.remove(entity);
		
	}

	@Override
	public Car get(int id) {
		for(Car c:db.cars)
		{
			if(c.getId()==id)
				return c;
		}
		return null;
	}

	@Override
	public List<Car> getAll() {
		return db.cars;
	}

	/* */
	
	@Override
	public List<Car> byClient(Client client) {
		return byClient(client.getId());
	}

	@Override
	public List<Car> byClient(String firstName, String surname, String pesel,
			String email, double phoneNumber) {
		
		for(Client c:db.clients)
		{
			if((c.getFirstName()==firstName) && (c.getSurname()==surname) && (c.getPesel()==pesel) && (c.getEmail()==email) && (c.getPhoneNumber()==phoneNumber))
				return c.getCars();
		}
		return new ArrayList<Car>();
	}

	@Override
	public List<Car> byClient(int clientId) {
		for(Client c:db.clients)
		{
			if(c.getId()==clientId)
				return c.getCars();
		}
		return new ArrayList<Car>();
	}

	/* */
	
	@Override
	public Car byService(Service service) {
		return byService(service.getId());
	}

	@Override
	public Car byService(boolean tiresChange, boolean oilChange,
			boolean wash, boolean painting, boolean mechanicReapair,
			boolean electricReapair, Date date) {
		
		for(Service s:db.services)
		{
			if((s.isTiresChange()==tiresChange) && (s.isOilChange()==oilChange) && (s.isWash()==wash) && (s.isPainting()==painting) && (s.isMechanicReapair()==mechanicReapair) && (s.isElectricReapair()==electricReapair) && (s.getDate()==date))
				return s.getCar();
		}
		return null;
	}

	@Override
	public Car byService(int serviceId) {
		
		for(Service s:db.services)
		{
			if(s.getId()==serviceId)
				return s.getCar();
		}
		return null;
	}
}
