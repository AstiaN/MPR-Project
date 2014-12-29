package repositories.impl;

import java.sql.*;  
import java.util.List;

import repositories.IUserRepository;
import domain.Client;
import domain.User;
import unitofwork.IUnitOfWork;



public class UserRepository extends Repository<User> implements IUserRepository{

	public UserRepository(Connection connection, IEntityBuilder<User> builder, IUnitOfWork uow) {
		super(connection, builder, uow);
	}
	
	protected String insertSql =
		"INSERT INTO user (login,password) VALUES(?,?)";
		
	protected String updateSql =
		"UPDATE users SET (login,password)=(?,?) WHERE id=?";
	
	@Override
	protected void setUpUpdateQuery(User entity) throws SQLException {
		update.setString(1, entity.getLogin());
		update.setString(2, entity.getPassword());
		update.setInt(3, entity.getId());
	}
	
	@Override
	protected void setUpInsertQuery(User entity) throws SQLException {
		insert.setString(1, entity.getLogin());
		insert.setString(2, entity.getPassword());
		insert.setInt(3, entity.getId());
	}
	@Override
	protected String getTableName() {
		return "user";
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
	public List<User> ofClients(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> ofClients(String firstName, String surname, String pesel,
			String email, double phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> ofClients(int clientId) {
		// TODO Auto-generated method stub
		return null;
	}

}
