package repositories.impl;

import java.sql.Connection;
import java.sql.SQLException;

import repositories.builder.IEntityBuilder;
import domain.Service;

public class ServiceRepository extends Repository<Service>{

	protected ServiceRepository(Connection connection,IEntityBuilder<Service> builder) {
		super(connection, builder);
	}
	
	protected String insertSql =
		"INSERT INTO service (make, model, year, mileage, fuelType, engine) VALUES(?,?,?,?,?,?)";
	
	protected String updateSql =
		"UPDATE service SET (make, model, year, mileage, fuelType, engine) = (?,?,?,?,?,?) WHERE id=?";

	@Override
	protected void setUpUpdateQuery(Service entity) throws SQLException {
		update.setBoolean(1, entity.isTiresChange());
		update.setBoolean(2, entity.isOilChange());
		update.setBoolean(3, entity.isWash());
		update.setBoolean(4, entity.isPainting());
		update.setBoolean(5, entity.isMechanicReapair());
		update.setBoolean(6, entity.isElectricReapair());
		update.setInt(7, entity.getId());
	}

	@Override
	protected void setUpInsertQuery(Service entity) throws SQLException {
		insert.setBoolean(1, entity.isTiresChange());
		insert.setBoolean(2, entity.isOilChange());
		insert.setBoolean(3, entity.isWash());
		insert.setBoolean(4, entity.isPainting());
		insert.setBoolean(5, entity.isMechanicReapair());
		insert.setBoolean(6, entity.isElectricReapair());
		insert.setInt(7, entity.getId());
	}

	@Override
	protected String getTableName() {
		return "service";
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
