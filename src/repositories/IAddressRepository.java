package repositories;

import java.util.List;

import domain.*;

public interface IAddressRepository extends IRepository<Address>{
	
	public List<Address> ofClients(Client client);
	public List<Address> ofClients(String firstName,String surname, String pesel, String email,double phoneNumber);
	public List<Address> ofClients(int clientId);

}
