package repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class abstract Repository {

	private Connection connection;
	
	private PreparedStatement insert;
	private PreparedStatement selectById;
	private PreparedStatement update;
	private PreparedStatement selectAll;
	private PreparedStatement delete;
}
