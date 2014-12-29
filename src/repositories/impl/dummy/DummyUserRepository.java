package repositories.impl.dummy;

import java.util.ArrayList; 
import java.util.List;

import domain.*;
import repositories.*;

public class DummyUserRepository implements IUserRepository{

	private DummyDb db;
	
	public DummyUserRepository(DummyDb db) {
		this.db = db;
	}

	@Override
	public void save(User entity) {
		db.users.add(entity);
		
	}

	@Override
	public void update(User entity) {
		
	}

	@Override
	public void delete(User entity) {
		db.users.remove(entity);
		
	}

	@Override
	public User get(int id) {
		
		for(User u:db.users)
		{
			if(u.getId()==id)
				return u;
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return db.users;
	}

	/* */
	
	@Override
	public List<User> ofClients(Client client) {
		return ofClients(client.getId());
	}

	@Override
	public List<User> ofClients(String firstName, String surname, String pesel,
			String email, double phoneNumber) {
		
		for(Client c:db.clients)
		{
			if((c.getFirstName()==firstName) && (c.getSurname()==surname) && (c.getPesel()==pesel) && (c.getEmail()==email) && (c.getPhoneNumber()==phoneNumber))
				return c.getUsers();
		}
		return new ArrayList<User>();
	}

	@Override
	public List<User> ofClients(int clientId) {
		for(Client c:db.clients)
		{
			if(c.getId()==clientId)
				return c.getUsers();
		}
		return new ArrayList<User>();
	}
}
