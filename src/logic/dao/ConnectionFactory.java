package logic.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.postgresql.Driver;

import logic.exception.MyRuntimeException;

public class ConnectionFactory {
		
	public static final String URL = "jdbc:postgresql://localhost:5432/PlayRoom";
	public static final String USER = "postgres";
	public static final String PASS = "ciao1234";
	
	//This class should not have public constructor due to static attributes. 
	private ConnectionFactory() {
	    throw new IllegalStateException("Utility class");
	  }
	
	/**
	 * Get a connection to database 
	 * @return Connection object
	 * @throws MyRuntimeException 
	 */
		
	public static Connection getConnection() throws MyRuntimeException {
		try {
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			throw new MyRuntimeException(ex.getMessage());
		}
	}	
}
