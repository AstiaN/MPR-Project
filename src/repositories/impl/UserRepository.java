package repositories.impl;

import java.sql.Connection;  
import java.sql.SQLException;

import repositories.builder.IEntityBuilder;
import domain.User;

public class UserRepository extends Repository<User> {

	public UserRepository(Connection connection, IEntityBuilder<User> builder) {
		super(connection, builder);
	}
	
	protected String insertSql=
		"INSERT INTO user (login,password) VALUES(?,?)";
	
	protected String updateSql=
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
	
	


	
	

	

	

	

}
