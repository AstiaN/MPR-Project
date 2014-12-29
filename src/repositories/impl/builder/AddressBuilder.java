package repositories.impl.builder;

import java.sql.*;

import domain.Address;

public class AddressBuilder implements IEntityBuilder<Address> {
	
	@Override
	public Address build(ResultSet rs) throws SQLException {
		
		Address address = new Address();
		address.setCountry(rs.getString("country"));
		address.setCity(rs.getString("city"));
		address.setPostCode(rs.getString("postCode"));
		address.setStreet(rs.getString("street"));
		address.setNumber(rs.getString("number"));
		address.setId(rs.getInt("id"));
		return address;
		}
}