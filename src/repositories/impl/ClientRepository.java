package repositories.impl;

import java.sql.Connection; 
import java.sql.SQLException;

import repositories.builder.IEntityBuilder;
import domain.Client;

public class ClientRepository extends Repository<Client>{

	protected ClientRepository(Connection connection,IEntityBuilder<Client> builder) {
		super(connection, builder);
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
	
	
	
}