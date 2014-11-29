package repositories;

public interface IRepositoryCatalog {
	
	public IUserRepository getUsers();
	public IServiceRepository getServices();
	public IClientRepository getClients();
	public IAddressRepository getAddresses();
	public ICarRepository getCars();

}
