package utils;

import java.sql.*;

public class DbConector {
	private static DbConector instance;
	private final PropertiesManger pManager = PropertiesManger.getInstance(); 
	private final String DB_URL = pManager.getProperties().getProperty("DB_URL");
	private final String USER = pManager.getProperties().getProperty("USER");
	private final String PASSWORD = pManager.getProperties().getProperty("PASSWORD");
	private final String DRIVER = pManager.getProperties().getProperty("DRIVER");
	private static Connection con;

	private DbConector() {
	}

	public static DbConector getInstance() {
		if (instance == null) {
			instance = new DbConector();
		}
		return instance;
	}

	private void createConection() {

		try {
			Class.forName(DRIVER).newInstance();
			System.out.println("Connecting to datbase");
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);

		} catch (ClassNotFoundException e) {
			System.out.println("Where is your class?");
		} catch (SQLException e) {
			System.out.println("Couldn't connect to Database");
		} catch (Exception e) {
			System.out.println("Something is wrong!!!");
		}

	}

	public Connection getConnection() {
		if (con == null) {
			createConection();
		}

		return con;
	}

	public static void closeConnection() {
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				System.out.println("There is no connection");
			}
		}
	}

}
