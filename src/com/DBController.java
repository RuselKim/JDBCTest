package com;

import java.sql.*;
import java.util.ArrayList;

public class DBController {
	private Conector con = Conector.getInstance();
	
	public ArrayList selectCars(){
		ArrayList carsList = new ArrayList();
		Connection connection = con.getConnection();
		Statement selectCars;
		try {
			selectCars = connection.createStatement();
			String query = "Select * from cars";
			ResultSet result;
			result = selectCars.executeQuery(query);
	
			while (result.next()){
				int id = result.getInt("id");
				String model = result.getString("model");
				int price = result.getInt("price");
				System.out.println(id + "  " + model+"   "+price);
			}
		} catch (SQLException e) {
			System.out.println("Bad query");
		}
		
		return carsList;
	}
	
	public ArrayList selectShops(){
		ArrayList shopsList = new ArrayList();
		Connection connection = con.getConnection();
		Statement selectShops;
		try {
			selectShops = connection.createStatement();
			String query = "Select * from shops";
			ResultSet result;
			result = selectShops.executeQuery(query);
	
			while (result.next()){
				int id = result.getInt("id");
				String name = result.getString("name");
				int adress = result.getInt("adress");
				System.out.println(id + "  " + name+"   "+adress);
			}
		} catch (SQLException e) {
			System.out.println("Bad query");
		}
		
		return shopsList;
	}
	
	public void insertCars (Cars car){
		String query = "Insert into cars (model,price,"
		Connection connection = con.getConnection();
		PreparedStatement pstmt = connection.prepareStatement();
		
		
	}
	
	
}
