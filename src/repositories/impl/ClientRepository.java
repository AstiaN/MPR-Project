package repositories.impl;

import java.sql.*;  
import java.util.List;

import repositories.IClientRepository;
import domain.Address;
import domain.Car;
import domain.Client;
import domain.User;
import unitofwork.IUnitOfWork;

public class ClientRepository extends Repository<Client> implements IClientRepository{

	protected ClientRepository(Connection connection, IEntityBuilder<Client> builder, IUnitOfWork uow) {
		super(connection, builder, uow);
	}
	
	protected String insertSql =
			"INSERT INTO client (firstName, surname, pesel, email, phoneNmber) VALUES(?,?,?,?,?)";
		
		protected String updateSql =
				"UPDATE client SET (firstName, surname, pesel, email, phoneNmber) = (?,?,?,?,?) WHERE id=?";
	
	@Override
	protected void setUpUpdateQuery(Client entity) throws SQLException {
		update.setString(1, entity.getFirstName());
		update.setString(2, entity.getSurname());
		update.setString(3, entity.getPesel());
		update.setString(4, entity.getEmail());
		update.setDouble(5, entity.getPhoneNumber());
		update.setInt(6, entity.getId());
	}

	@Override
	protected void setUpInsertQuery(Client entity) throws SQLException {
		insert.setString(1, entity.getFirstName());
		insert.setString(2, entity.getSurname());
		insert.setString(3, entity.getPesel());
		insert.setString(4, entity.getEmail());
		insert.setDouble(5, entity.getPhoneNumber());
		insert.setInt(6, entity.getId());
	}

	@Override
	protected String getTableName() {
		return "client";
	}

	@Override
	protected String getUpdateQuery() {
		return updateSql;
	}

	@Override
	protected String getInsertQuery() {
		return insertSql;
	}

	@Override
	public Client byUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client byUser(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client byUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client byAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client byAddress(String country, String city, String postCode,
			String street, String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client byAddress(int addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> ofCar(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> ofCar(String make, String model, int year,
			double mileage, String fuelType, int engine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> ofCar(int carId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}