package repositories.builder;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Client;

public class ClientBuilder implements IEntityBuilder<Client> {
	
	@Override
	public Client build(ResultSet rs) throws SQLException {
		Client client = new Client();
		client.setFirstName(rs.getString("firstName"));
		client.setSurname(rs.getString("surname"));
		client.setPesel(rs.getString("pesel"));
		client.setEmail(rs.getString("email"));
		client.setPhoneNumber(rs.getDouble("phoneNumber"));
		client.setId(rs.getInt("id"));
		return client;
		}
}