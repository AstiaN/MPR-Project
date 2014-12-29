package repositories.impl.builder;

import java.sql.*;

import domain.Car;

public class CarBuilder implements IEntityBuilder<Car> {
	
	@Override
	public Car build(ResultSet rs) throws SQLException {
		
		Car car = new Car();
		car.setMake(rs.getString("make"));
		car.setModel(rs.getString("model"));
		car.setYear(rs.getInt("year"));
		car.setMileage(rs.getDouble("mileage"));
		car.setFuelType(rs.getString("fuelType"));
		car.setEngine(rs.getInt("engine"));
		car.setId(rs.getInt("id"));
		return car;
		}
}