import java.sql.*;  

import domain.*;
import repositories.*;
import repositories.impl.*;
import repositories.impl.builder.*;
import unitofwork.IUnitOfWork;
import unitofwork.UnitOfWork;

public class Main {

	public static void main(String[] args) {

		System.out.println("Serwis samochodowy");
		
		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "";
		
		try {
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			IUnitOfWork uow = new UnitOfWork(connection);
			
Statement stmt = connection.createStatement();
			
			stmt.execute("CREATE DATABASE IF NOT EXISTS car_service");
			stmt.execute("USE car_service");
			stmt.execute("DROP TABLE IF EXISTS addresses");
			stmt.execute("DROP TABLE IF EXISTS cars");
			stmt.execute("DROP TABLE IF EXISTS clients");
			stmt.execute("DROP TABLE IF EXISTS services");
			stmt.execute("DROP TABLE IF EXISTS users");
			
			
			String createAdressTable=
					"CREATE TABLE addresses ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "country VARCHAR(30),"
					+ "city VARCHAR(30)"
					+ "postCode VARCHAR(10)"
					+ "street VARCHAR(30)"
					+ "number VARCHAR(10)"
					+ ")";
			
			String createCarTable=
					"CREATE TABLE cars ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "make VARCHAR(30),"
					+ "model VARCHAR(40),"
					+ "year CHAR(4)"
					+ "mileage CHAR(12),"
					+ "fuelType VARCHAR(20),"
					+ "engine VARCHAR(10),"
					+ ")";
			
			String createClientTable=
					"CREATE TABLE clients ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "firstname VARCHAR(30),"
					+ "surname VARCHAR(40),"
					+ "pesel CHAR(11),"
					+ "email VARCHAR(60),"
					+ "phoneNumber VARCHAR(16),"
					+ ")";
			
			String createServiceTable=
					"CREATE TABLE services ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "tiresChange BIT(NULL),"
					+ "oilChange BIT(NULL)"
					+ "wash BIT(NULL)"
					+ "painting BIT(NULL)"
					+ "mechanicReapair BIT(NULL)"
					+ "electricReapair BIT(NULL)"
					+ ")";
			
			String createUserTable=
					"CREATE TABLE users ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "login VARCHAR(30),"
					+ "password VARCHAR(64),"
					+ ")";
			
			stmt.executeUpdate(createAdressTable); 
			stmt.executeUpdate(createCarTable); 
			stmt.executeUpdate(createClientTable);
			stmt.executeUpdate(createServiceTable);
			stmt.executeUpdate(createUserTable);
			
			
			IRepository<Address> addresses = new AddressRepository(connection, new AddressBuilder(), uow);
			IRepository<Car> cars = new CarRepository(connection, new CarBuilder(), uow);
			IRepository<Client> clients = new ClientRepository(connection, new ClientBuilder(), uow);
			IRepository<Service> services = new ServiceRepository(connection, new ServiceBuilder(), uow);
			IRepository<User> users = new UserRepository(connection, new UserBuilder(), uow);
	
			//---------------- NA DZIŒ KONIEC --------------------
			
			Student sluchacz1 = new Student();
			sluchacz1.setFirstName("Anna");
			sluchacz1.setLastName("Kowalska");
			sluchacz1.setPesel("82020212345");
			Student sluchacz2 = new Student();
			sluchacz2.setFirstName("Iwona");
			sluchacz2.setLastName("Iwonowska");
			sluchacz2.setPesel("72020212345");
			
			Teacher lektor1 = new Teacher();
			lektor1.setFirstName("Ewa");
			lektor1.setLastName("Wiœniewska");
			
			Language angielskiB1 = new Language();
			angielskiB1.setName("English");
			angielskiB1.setLevel("Intermediate");
			
			Address adres1 = new Address();
			adres1.setCountry("Polska");
			adres1.setCity("Gdañsk");
			adres1.setPostalCode("80-808");
			adres1.setStreet("Brzegi");
			adres1.setHouseNumber("55");
			adres1.setLocalNumber("1");
			
			
			//add
			
			students.add(sluchacz1);
			students.add(sluchacz2);
			teachers.add(lektor1);
			languages.add(angielskiB1);
			addresses.add(adres1);
			
			uow.commit();
			
			System.out.println("Wszyscy studenci w bazie:");
			for(Student fromDb : students.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName()+" "
				+fromDb.getPesel());
			
			System.out.println("Wszyscy nauczyciele w bazie:");
			for(Teacher fromDb : teachers.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName());
			
			System.out.println("Wszystkie jêzyki w bazie:");
			for(Language fromDb : languages.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getName()+" "+fromDb.getLevel());
			
			System.out.println("Wszystkie adresy w bazie:");
			for(Address fromDb : addresses.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getCountry()+", "+fromDb.getCity()+", "
				+fromDb.getPostalCode()+", "+fromDb.getStreet()+", "+fromDb.getHouseNumber()+"/"
				+fromDb.getLocalNumber());
			
			//update
			
			sluchacz2 = students.get(2);
			sluchacz2.setLastName("Piwonowska");
			students.update(sluchacz2);
			
			uow.commit();
			
			System.out.println("Wszyscy studenci w bazie:");
			for(Student fromDb : students.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName()+" "
				+fromDb.getPesel());
			
			//delete
			
			Student toDel = students.getAll().get(0);
			students.delete(toDel);
			
			uow.commit();
			
			System.out.println("Wszyscy studenci w bazie:");
			for(Student fromDb : students.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName()+" "
				+fromDb.getPesel());
			
			
			System.out.println("Student o id 2 to: "+students.get(2).getFirstName()+" "+students.get(2).getLastName());
			
			
			stmt.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
	}
}
		
		