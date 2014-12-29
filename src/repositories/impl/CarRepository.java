package repositories.impl;

import java.sql.*;
import java.util.List;

import repositories.ICarRepository;
import domain.Car;
import domain.Client;
import domain.Service;
import unitofwork.IUnitOfWork;

public class CarRepository extends Repository<Car> implements ICarRepository{

	protected CarRepository(Connection connection, IEntityBuilder<Car> builder, IUnitOfWork uow) {
		super(connection, builder, uow);
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
		return "UPDATE car SET (make, model, year, mileage, fuelType, engine) = (?,?,?,?,?,?) WHERE id=?";
	}

	@Override
	protected String getInsertQuery() {
		return "INSERT INTO car (make, model, year, mileage, fuelType, engine) VALUES(?,?,?,?,?,?)";
	}

	@Override
	public List<Car> byClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> byClient(String firstName, String surname, String pesel,
			String email, double phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> byClient(int clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car byService(Service service) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car byService(boolean tiresChange, boolean oilChange, boolean wash,
			boolean painting, boolean mechanicReapair, boolean electricReapair) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car byService(int serviceId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

