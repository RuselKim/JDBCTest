package com;

import java.sql.*;

public class Conector {
 private static Conector instance;
 static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
 static final String USER = "root";
 static final String PASSWORD = "root";
 private static Connection con;
 
 private Conector(){
 }
 
 public static Conector getInstance(){
	 if (instance == null){
		 instance = new Conector();
	 }
	 return instance;
 }
 
 private void createConection (){
	 
	 try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		System.out.println("Connecting to datbase");
		con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
	
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your class?");
	} catch (SQLException e) {
		System.out.println("Couldn't connect to Database");
	} catch (Exception e) {
		System.out.println ("Something is wrong!!!");
	}
	 
 }
 
 public Connection getConnection(){
	 if (con == null){
		 createConection();
	 }
	 
	 return con;
 }
 
 public static void closeConnection(){
	 if (con != null){
		 try {
			con.close();
			con = null;
		} catch (SQLException e) {
			System.out.println("There is no connection");
		}
	 }
 }
 
}
