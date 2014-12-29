package repositories.impl;

import java.sql.Connection; 

import repositories.impl.builder.*;
import repositories.IAddressRepository;
import repositories.ICarRepository;
import repositories.IClientRepository;
import repositories.IServiceRepository;
import repositories.IUserRepository;
import repositories.IRepositoryCatalog;

import unitofwork.IUnitOfWork;

public class RepositoryCatalog implements IRepositoryCatalog{

	private Connection connection;
	private IUnitOfWork uow;
	
	public RepositoryCatalog(Connection connection, IUnitOfWork uow) {
		super();
		this.connection = connection;
		this.uow = uow;
	}

	@Override
	public IUserRepository getUsers() {
		// TODO Auto-generated method stub
		return new UserRepository(connection, new UserBuilder(), uow);
	}

	@Override
	public IServiceRepository getServices() {
		// TODO Auto-generated method stub
		return new ServiceRepository(connection, new ServiceBuilder(), uow);
	}

	@Override
	public IClientRepository getClients() {
		// TODO Auto-generated method stub
		return new ClientRepository(connection, new ClientBuilder(), uow);
	}

	@Override
	public IAddressRepository getAddresses() {
		// TODO Auto-generated method stub
		return new AddressRepository(connection, new AddressBuilder(), uow);
	}

	@Override
	public ICarRepository getCars() {
		// TODO Auto-generated method stub
		return new CarRepository(connection, new CarBuilder(), uow);
	}
	
}

	