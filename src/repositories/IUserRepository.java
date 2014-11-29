package repositories;

import java.util.List; 

import domain.*;

public interface IUserRepository extends IRepository<User>{

	public List<User> ofClients(Client client);
	public List<User> ofClients(String firstName,String surname, String pesel, String email,double phoneNumber);
	public List<User> ofClients(int clientId);
}

