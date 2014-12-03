package repositories.builder;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User;

public class UserBuilder implements IEntityBuilder<User> {
	
	@Override
	public User build(ResultSet rs) throws SQLException {
		
		User user = new User();
		user.setLogin(rs.getString("login"));
		user.setPassword(rs.getString("password"));
		user.setId(rs.getInt("id"));
		return user;
	}

}
