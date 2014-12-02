package repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repositories.IRepository;
import domain.User;

public class UserRepository implements IRepository<User> {

	private Connection connection;
		
	private String insertSql=
				"INSERT INTO users(login,password) VALUES(?,?)";
	private String selectByIdSql=
				"SELECT * FROM users WHERE id=?";
	private String updateSql=
				"UPDATE users SET (login,password)=(?,?) WHERE id=?";
	private String deleteSql=
				"DELETE FROM users WHERE id=?";
	private String selectAllSql=
				"SELECT * FROM users";

	private PreparedStatement insert;
	private PreparedStatement selectById;
	private PreparedStatement update;
	private PreparedStatement selectAll;
	private PreparedStatement delete;
	
public UserRepository(Connection connection) {
		
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
	public void save(User entity) {
		try {
			insert.setString(1, entity.getLogin());
			insert.setString(2, entity.getPassword());
			insert.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	@Override
	public void update(User entity) {
		try {
			update.setString(1, entity.getLogin());
			update.setString(2, entity.getPassword());
			update.setInt(3, entity.getId());
			update.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	@Override
	public void delete(User entity) {
		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
	}
	@Override
	public User get(int id) {
		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next())
			{
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<User> getAll() {
		List<User> result = new ArrayList<User>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next())
			{
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				result.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
