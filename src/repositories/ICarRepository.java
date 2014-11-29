package repositories;

import java.util.Date; 
import java.util.List;

import domain.*;

public interface ICarRepository extends IRepository<Car>{

	public List <Car> byClient(Client client);
	public List <Car> byClient(String firstName,String surname, String pesel, String email,double phoneNumber);
	public List <Car> byClient(int clientId);
	
	public Car byService(Service service);
	public Car byService(boolean tiresChange, boolean oilChange, boolean wash, boolean painting, boolean mechanicReapair, boolean electricReapair, Date date);
	public Car byService(int serviceId);
}