package logic.dao;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
		
	public static final String URL = "jdbc:postgresql://localhost:5432/PlayRoom";
	public static final String USER = "postgres";
	public static final String PASS = "ciao1234";
	
	/**
	 * Get a connection to database 
	 * @return Connection object
	 */
		
	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		}
	}	
}
