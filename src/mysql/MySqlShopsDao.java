package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.MySQLConector;
import com.Shops;






import dao.ShopsDao;

public class MySqlShopsDao implements ShopsDao {
	
	MySQLConector connector = MySQLConector.getInstance();
		

	/** Получаем все строки таблицы shops*/
	
	public ArrayList<Shops> getAllShops() {
		Connection con = connector.getConnection();
		ArrayList<Shops> shopsList = new ArrayList<Shops>();
		Statement selectShops;
		try {
			selectShops = con.createStatement();
			String query = "Select * from shops;";
			ResultSet result = selectShops.executeQuery(query);
	
			while (result.next()){
				int id = result.getInt("id_shops");
				String name = result.getString("name");
				String adress = result.getString("adress");
				Shops shop = new Shops(id,name,adress);
				shopsList.add(shop);
			}
			selectShops.close();
		} catch (SQLException e) {
			System.out.println("Bad select query");
			e.printStackTrace();
		}
		
		return shopsList;
	}

	
	/** Возвращает конретную строку по id*/
	
	public Shops getShop(int id) {
		Shops shop = null;
		Connection con = connector.getConnection();
		
		try {
			String query = "Select * from shops where id = ?;";
			PreparedStatement selectShop = con.prepareStatement(query);
			selectShop.setInt(1,id);
			ResultSet result = selectShop.executeQuery();
			result.next();
			shop = new Shops(result.getInt("id"),result.getString("name"),result.getString("adress"));
	
			selectShop.close();
		} catch (SQLException e) {
			System.out.println("Bad select query");
		}
		return shop;
	}

	public void insertShops(Shops shop) {
		Connection con = connector.getConnection();
		String query = "Insert into shops (name,adress)values(?,?);";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,shop.getName());
			pstmt.setString(2,shop.getAdress());
			pstmt.executeUpdate();
			System.out.println("insert into shops complit");
		} catch (SQLException e) {
			System.out.println("bad insert query");
			e.printStackTrace();
		}
		
	}

	public void updateShops(Shops shop) {
		Connection con = connector.getConnection();
		String query = "Update shops set name=?, adress=? where id=?;";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,shop.getName());
			pstmt.setString(2,shop.getAdress());
			pstmt.setInt(3,shop.getId());
			pstmt.executeUpdate();
			System.out.println("shops is updated");
		} catch (SQLException e) {
			System.out.println("bad update query");
		}
		
	}

	public void deleteShops(int id) {
		Connection con = connector.getConnection();
		String query = "Delete from shops where id = " + id + ";";
		try {
			Statement stmt = con.prepareStatement(query);
			stmt.executeQuery(query);
			System.out.println("shop is deleted");
		} catch (SQLException e) {
			System.out.println("bad delete query");
		}
	}

}
