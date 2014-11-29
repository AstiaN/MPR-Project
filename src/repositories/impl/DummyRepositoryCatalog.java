package repositories.impl;

import repositories.*;

public class DummyRepositoryCatalog implements IRepositoryCatalog{

	private DummyDb db = new DummyDb();

	@Override
	public IUserRepository getUsers() {
		return new DummyUserRepository(db);
	}

	@Override
	public IServiceRepository getServices() {
		return new DummyServiceRepository(db);
	}

	@Override
	public IClientRepository getClients() {
		return new DummyClientRepository(db);
	}

	@Override
	public IAddressRepository getAddresses() {
		return new DummyAddressRepository(db);
	}

	@Override
	public ICarRepository getCars() {
		return new DummyCarRepository(db);
	}
}
