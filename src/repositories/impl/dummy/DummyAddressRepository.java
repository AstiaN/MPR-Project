package repositories.impl.dummy;

import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.*;

public class DummyAddressRepository implements IAddressRepository {

	private DummyDb db;

	public DummyAddressRepository(DummyDb db) {
		this.db = db;
	}

	@Override
	public void save(Address entity) {
		db.addresses.add(entity);
	}

	@Override
	public void update(Address entity) {

	}

	@Override
	public void delete(Address entity) {
		db.addresses.remove(entity);
	}

	@Override
	public Address get(int id) {

		for (Address a : db.addresses) {
			if (a.getId() == id)
				return a;
		}
		return null;
	}

	@Override
	public List<Address> getAll() {
		return db.addresses;
	}

	/* */

	@Override
	public List<Address> ofClients(Client client) {
		return ofClients(client.getId());
	}

	@Override
	public List<Address> ofClients(String firstName, String surname,
			String pesel, String email, double phoneNumber) {

		for (Client c : db.clients) {
			if ((c.getFirstName() == firstName) && (c.getSurname() == surname)
					&& (c.getPesel() == pesel) && (c.getEmail() == email)
					&& (c.getPhoneNumber() == phoneNumber))
				return c.getAddresses();
		}
		return new ArrayList<Address>();
	}

	@Override
	public List<Address> ofClients(int clientId) {

		for (Client c : db.clients) {
			if (c.getId() == clientId)
				return c.getAddresses();
		}
		return new ArrayList<Address>();
	}
}
