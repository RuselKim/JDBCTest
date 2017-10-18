package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.Shops;


import dao.ShopsDao;

public class MySqlShopsDao implements ShopsDao {
	
	private final Connection con;
	
	
	public MySqlShopsDao (Connection connection){
		this.con = connection;
	}
	
	
	

	/** Получаем все строки таблицы shops*/
	
	public ArrayList getAllShops() {
		ArrayList shopsList = new ArrayList();
		Statement selectShops;
		try {
			selectShops = con.createStatement();
			String query = "Select * from shops;";
			ResultSet result = selectShops.executeQuery(query);
	
			while (result.next()){
				int id = result.getInt("id");
				String name = result.getString("name");
				String adress = result.getString("adress");
				Shops shop = new Shops(id,name,adress);
				shopsList.add(shop);
			}
			selectShops.close();
		} catch (SQLException e) {
			System.out.println("Bad query");
		}
		
		return shopsList;
	}

	
	/** Возвращает конретную строку по id*/
	
	public Shops getShop(int id) {
		Shops shop = null;
		
		try {
			String query = "Select * from shops where id = ?;";
			PreparedStatement selectShop = con.prepareStatement(query);
			selectShop.setInt(1,id);
			ResultSet result = selectShop.executeQuery();
			result.next();
			shop = new Shops(result.getInt("id"),result.getString("name"),result.getString("adress"));
	
			selectShop.close();
		} catch (SQLException e) {
			System.out.println("Bad query");
		}
		return shop;
	}

	public void insertShops(Shops shop) {
		// TODO Auto-generated method stub
		
	}

	public void updateShops(Shops shop) {
		// TODO Auto-generated method stub
		
	}

	public void deleteShops(Shops shop) {
		// TODO Auto-generated method stub
		
	}

}
