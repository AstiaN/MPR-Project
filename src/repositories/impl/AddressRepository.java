package repositories.impl;

import java.sql.*;
import java.util.List;

import repositories.IAddressRepository;
import domain.Address;
import domain.Client;
import unitofwork.IUnitOfWork;

public class AddressRepository extends Repository<Address> implements IAddressRepository{

	protected AddressRepository(Connection connection, IEntityBuilder<Address> builder,IUnitOfWork uow) {
		super(connection, builder, uow);
	}
	
	protected String insertSql =
		"INSERT INTO address (countr, city, postCode, street, number) VALUES(?,?,?,?,?)";
	
	protected String updateSql =
		"UPDATE address SET(countr, city, postCode, street, number) = (?,?,?,?,?) WHERE id=?";

	@Override
	protected void setUpUpdateQuery(Address entity) throws SQLException {
		update.setString(1, entity.getCountry());
		update.setString(2, entity.getCity());
		update.setString(3, entity.getPostCode());
		update.setString(4, entity.getStreet());
		update.setString(5, entity.getNumber());
		update.setInt(6, entity.getId());
	}

	@Override
	protected void setUpInsertQuery(Address entity) throws SQLException {
		insert.setString(1, entity.getCountry());
		insert.setString(2, entity.getCity());
		insert.setString(3, entity.getPostCode());
		insert.setString(4, entity.getStreet());
		insert.setString(5, entity.getNumber());
		insert.setInt(6, entity.getId());
	}

	@Override
	protected String getTableName() {
		return "address";
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
	public List<Address> ofClients(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> ofClients(String firstName, String surname,
			String pesel, String email, double phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> ofClients(int clientId) {
		// TODO Auto-generated method stub
		return null;
	}
		
}