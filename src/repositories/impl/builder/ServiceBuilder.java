package repositories.impl.builder;

import java.sql.*;

import repositories.impl.IEntityBuilder;
import domain.Service;

public class ServiceBuilder implements IEntityBuilder<Service> {
	
	@Override
	public Service build(ResultSet rs) throws SQLException {
		
		Service service = new Service();
		service.setTiresChange(rs.getBoolean("tiresChange"));
		service.setOilChange(rs.getBoolean("oilChange"));
		service.setWash(rs.getBoolean("wash"));
		service.setPainting(rs.getBoolean("painting"));
		service.setMechanicReapair(rs.getBoolean("mechanicReapair"));
		service.setElectricReapair(rs.getBoolean("electricReapair"));
		service.setId(rs.getInt("id"));
		return service;
		}
}