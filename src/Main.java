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
			//stmt.execute("DROP TABLE IF EXISTS addresses");
			//stmt.execute("DROP TABLE IF EXISTS cars");
			stmt.execute("DROP TABLE IF EXISTS clients");
			//stmt.execute("DROP TABLE IF EXISTS services");
			stmt.execute("DROP TABLE IF EXISTS users");
			
			
			/*String createAdressTable=
					"CREATE TABLE addresses ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "country VARCHAR(30),"
					+ "city VARCHAR(30),"
					+ "postCode VARCHAR(10),"
					+ "street VARCHAR(30),"
					+ "number VARCHAR(10)"
					+ ")";*/
			
			/*String createCarTable=
					"CREATE TABLE cars ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "make VARCHAR(30),"
					+ "model VARCHAR(40),"
					+ "year CHAR(4),"
					+ "mileage CHAR(12),"
					+ "fuelType VARCHAR(20),"
					+ "engine VARCHAR(10)"
					+ ")";*/
			
			String createClientTable=
					"CREATE TABLE clients ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "firstname VARCHAR(30),"
					+ "surname VARCHAR(40),"
					+ "pesel CHAR(11),"
					+ "email VARCHAR(60),"
					+ "phoneNumber VARCHAR(16)"
					+ ")";
			
			/*String createServiceTable=
					"CREATE TABLE services ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "tiresChange BIT(1),"
					+ "oilChange BIT(1),"
					+ "wash BIT(1),"
					+ "painting BIT(1),"
					+ "mechanicReapair BIT(1),"
					+ "electricReapair BIT(1)"
					+ ")";*/
			
			String createUserTable=
					"CREATE TABLE users ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "login VARCHAR(30),"
					+ "password VARCHAR(64)"
					+ ")";
			
			//stmt.executeUpdate(createAdressTable); 
			//stmt.executeUpdate(createCarTable); 
			stmt.executeUpdate(createClientTable);
			//stmt.executeUpdate(createServiceTable);
			stmt.executeUpdate(createUserTable);
			
			
			//IRepository<Address> addresses = new AddressRepository(connection, new AddressBuilder(), uow);
			//IRepository<Car> cars = new CarRepository(connection, new CarBuilder(), uow);
			IRepository<Client> clients = new ClientRepository(connection, new ClientBuilder(), uow);
			//IRepository<Service> services = new ServiceRepository(connection, new ServiceBuilder(), uow);
			IRepository<User> users = new UserRepository(connection, new UserBuilder(), uow);
	
			//---------------- NA DZIŒ KONIEC --------------------
			
			User user1 = new User();
			user1.setLogin("GalAnonim");
			user1.setPassword("1234567890");
			User user2 = new User();
			user1.setLogin("User");
			user1.setPassword("pass");
			
			
			Client client1 = new Client();
			client1.setFirstName("Adam");
			client1.setSurname("Kowalski");
			client1.setPesel("45666666666");
			client1.setEmail("123@wp.pl");
			client1.setPhoneNumber(123456);
			
			Client client2 = new Client();
			client1.setFirstName("Jan");
			client1.setSurname("Nowak");
			client1.setPesel("45666666666");
			client1.setEmail("123@wp.pl");
			client1.setPhoneNumber(123456);
			
			
			
			
			//add
			
			users.save(user1);
			users.save(user2);
			clients.save(client1);
			clients.save(client2);
			
			uow.commit();
			
			System.out.println("Wszyscy u¿ytkownicy w bazie:");
			for(User fromDb : users.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getLogin()+" "+fromDb.getPassword());
			
			System.out.println("Wszyscy klienci w bazie:");
			for(Client fromDb : clients.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getSurname());
			
			
			//update
			
			client2 = clients.get(2);
			client2.setSurname("Kowalski");
			clients.update(client2);
			
			uow.commit();
			
			System.out.println("Wszyscy klienci w bazie:");
			for(Client fromDb : clients.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getSurname());
			
			//delete
			
			Client toDel = clients.getAll().get(0);
			clients.delete(toDel);
			
			uow.commit();
			
			System.out.println("Wszyscy klienci w bazie:");
			for(Client fromDb : clients.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getSurname());
			
			
			System.out.println("Student o id 2 to: "+clients.get(2).getFirstName()+" "+clients.get(2).getSurname());
			
			
			stmt.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
		
		