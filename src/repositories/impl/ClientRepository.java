package repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repositories.IRepository;
import domain.Client;

public class ClientRepository implements IRepository<Client> {

	private Connection connection;
		
	private String insertSql=
				"INSERT INTO clients(firstName, surname, pesel, email, phoneNumber) VALUES(?,?,?,?,?)";
	private String selectByIdSql=
				"SELECT * FROM clients WHERE id=?";
	private String updateSql=
				"UPDATE clients SET (firstName, surname, pesel, email, phoneNumber)=(?,?,?,?,?) WHERE id=?";
	private String deleteSql=
				"DELETE FROM clients WHERE id=?";
	private String selectAllSql=
				"SELECT * FROM clients";

	private PreparedStatement insert;
	private PreparedStatement selectById;
	private PreparedStatement update;
	private PreparedStatement selectAll;
	private PreparedStatement delete;
	
public ClientRepository(Connection connection) {
		
		this.connection = connection;
		try 
		{
			insert = connection.prepareStatement(insertSql);
			selectById=connection.prepareStatement(selectByIdSql);
			update=connection.prepareStatement(updateSql);
			delete=connection.prepareStatement(deleteSql);
			selectAll=connection.prepareStatement(selectAllSql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void save(Client entity) {
		try {
			insert.setString(1, entity.getFirstName());
			insert.setString(2, entity.getSurname());
			insert.setString(3, entity.getPesel());
			insert.setString(4, entity.getEmail());
			insert.setDouble(5, entity.getPhoneNumber()); 
			insert.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	@Override
	public void update(Client entity) {
		try {
			update.setString(1, entity.getFirstName());
			update.setString(2, entity.getSurname());
			update.setString(3, entity.getPesel());
			update.setString(4, entity.getEmail());
			update.setDouble(5, entity.getPhoneNumber());
			update.setInt(3, entity.getId());
			update.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	@Override
	public void delete(Client entity) {
		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
	}
	@Override
	public Client get(int id) {
		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next())
			{
				Client client = new Client();
				client.setId(rs.getInt("id"));
				client.setFirstName(rs.getString("FirstName"));
				client.setSurname(rs.getString("SurName"));
				client.setPesel(rs.getString("Pesel"));
				client.setEmail(rs.getString("Email"));
				client.setPhoneNumber(rs.getDouble("PhoneNumber"));
				return client;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Client> getAll() {
		List<Client> result = new ArrayList<Client>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next())
			{
				Client client = new Client();
				client.setId(rs.getInt("id"));
				client.setFirstName(rs.getString("FirstName"));
				client.setSurname(rs.getString("SurName"));
				client.setPesel(rs.getString("Pesel"));
				client.setEmail(rs.getString("Email"));
				client.setPhoneNumber(rs.getDouble("PhoneNumber"));
				result.add(client);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
