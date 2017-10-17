package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DBController {
	private Conector con = Conector.getInstance();
	
	public ArrayList selectCars(){
		ArrayList carsList = new ArrayList();
		Connection connection = con.getConnection();
		Statement selectCars;
		try {
			selectCars = connection.createStatement();
			String query = "Select * from cars;";
			ResultSet result;
			result = selectCars.executeQuery(query);
	
			while (result.next()){
				
				int id = result.getInt("id");
				String model = result.getString("model");
				int price = result.getInt("price");
				int shop_id = result.getInt("shops_id");
				Shops shop =(Shops) selectShops().get(shop_id);
				carsList.add(new Cars(id,model,price,shop));
			}
			
		} catch (SQLException e) {
			System.out.println("Bad query");
		}
		
		return carsList;
	}
	
	public Map<Integer, Shops> selectShops(){
		Map <Integer,Shops> shopsList = new HashMap<Integer,Shops>();
		Connection connection = con.getConnection();
		Statement selectShops;
		try {
			selectShops = connection.createStatement();
			String query = "Select * from shops;";
			ResultSet result = selectShops.executeQuery(query);
	
			while (result.next()){
				int id = result.getInt("id");
				String name = result.getString("name");
				String adress = result.getString("adress");
				Shops shop = new Shops(id,name,adress);
				shopsList.put(id, shop);
			}
			selectShops.close();
		} catch (SQLException e) {
			System.out.println("Bad query");
		}
		
		return shopsList;
	}
	
	public void insertCars (Cars car){
		String query = "Insert into cars (model,price,shops_id)values(?,?,?);";
		Connection connection = con.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1,car.getModel());
			System.out.println(car.getModel());
			pstmt.setInt(2,car.getPrice());
			System.out.println(car.getPrice());
			pstmt.setInt(3, car.getShopID().getId());
			System.out.println(car.getShopID().getId());
			pstmt.executeUpdate();
			System.out.println("insert into cars complit");
		} catch (SQLException e) {
			System.out.println("bad query");
		}
		
		
	}
	
	public void insertShops (Shops shop){
		String query = "Insert into shops (name,adress)values(?,?);";
		Connection connection = con.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1,shop.getName());
			pstmt.setString(2,shop.getAdress());
			pstmt.executeUpdate();
			System.out.println("insert into shops complit");
		} catch (SQLException e) {
			System.out.println("bad query");
		}
		
		
	}
	
	public void updateCars(Cars car){
		String query = "Update cars set model=?, price=?, shops_id=? where id=?;";
		Connection connection = con.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1,car.getModel());
			pstmt.setInt(2,car.getPrice());
			pstmt.setInt(3,car.getShopID().getId());
			pstmt.setInt(4,car.getId());
			pstmt.executeUpdate();
			System.out.println("cars is updated");
		} catch (SQLException e) {
			System.out.println("bad query");
		}
	}
	
	public void updateShops(Shops shop){
		String query = "Update shops set name=?, adress=? where id=?;";
		Connection connection = con.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1,shop.getName());
			pstmt.setString(2,shop.getAdress());
			pstmt.setInt(3,shop.getId());
			pstmt.executeUpdate();
			System.out.println("shops is updated");
		} catch (SQLException e) {
			System.out.println("bad query");
		}
	}
	
	public void deleteCars(Cars car){
		String query = "Delete from cars where id=?;";
		Connection connection = con.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1,car.getId());
			pstmt.executeUpdate();
			System.out.println("car is deleted");
		} catch (SQLException e) {
			System.out.println("bad query");
		}
	}
	
	public void deleteShops(Shops shop){
		String query = "Delete from shops where id=?;";
		Connection connection = con.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1,shop.getId());
			pstmt.executeUpdate();
			System.out.println("shop is deleted");
		} catch (SQLException e) {
			System.out.println("bad query");
		}
	}
	
	
}
