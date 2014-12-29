package repositories.impl;

import java.sql.Connection;
import java.sql.SQLException;

import repositories.impl.builder.IEntityBuilder;
import domain.Car;

public class CarRepository extends Repository<Car>{

	protected CarRepository(Connection connection,IEntityBuilder<Car> builder) {
		super(connection, builder);
	}
	
	protected String insertSql =
		"INSERT INTO car (make, model, year, mileage, fuelType, engine) VALUES(?,?,?,?,?,?)";
	
	protected String updateSql =
		"UPDATE car SET (make, model, year, mileage, fuelType, engine) = (?,?,?,?,?,?) WHERE id=?";

	@Override
	protected void setUpUpdateQuery(Car entity) throws SQLException {
		update.setString(1, entity.getMake());
		update.setString(2, entity.getModel());
		update.setInt(3, entity.getYear());
		update.setDouble(4, entity.getMileage());
		update.setString(5, entity.getFuelType());
		update.setInt(6, entity.getEngine());
		update.setInt(7, entity.getId());
	}

	@Override
	protected void setUpInsertQuery(Car entity) throws SQLException {
		insert.setString(1, entity.getMake());
		insert.setString(2, entity.getModel());
		insert.setInt(3, entity.getYear());
		insert.setDouble(4, entity.getMileage());
		insert.setString(5, entity.getFuelType());
		insert.setInt(6, entity.getEngine());
		insert.setInt(7, entity.getId());
	}

	@Override
	protected String getTableName() {
		return "car";
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

