package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.Cars;
import com.Shops;

import dao.CarsDao;

public class MySqlCarsDao implements CarsDao {
	
	private final Connection con;

	
	public MySqlCarsDao(Connection connection){
		this.con = connection;
	}

	
	public ArrayList getAllCars() {
		ArrayList carsList = new ArrayList();
		Statement selectCars;
		try {
			selectCars = con.createStatement();
			String query = "Select * from cars;";
			ResultSet result = selectCars.executeQuery(query);
	
			while (result.next()){
				int id = result.getInt("id");
				String model = result.getString("model");
				int price = result.getInt("price");
				Shops shop_id = new MySqlShopsDao(con).getShop(result.getInt("shops_id"));
				Cars car = new Cars(id,model,price,shop_id);
				carsList.add(car);
			}
			selectCars.close();
		} catch (SQLException e) {
			System.out.println("Bad query");
		}
		return carsList;
	}

	
	public Cars getCar(int id) {
		Cars car = null;
		
		try {
			String query = "Select * from cars where id = ?;";
			PreparedStatement selectCars = con.prepareStatement(query);
			selectCars.setInt(1,id);
			ResultSet result = selectCars.executeQuery();
			result.next();
			
			Shops shop_id = new MySqlShopsDao(con).getShop(result.getInt("shops_id"));
			
			car = new Cars(result.getInt("id"),
					result.getString("model"),result.getInt("price"),shop_id);
	
			selectCars.close();
		} catch (SQLException e) {
			System.out.println("Bad query");
		}
		return car;
	}


	public void insertCars(Cars car) {
		// TODO Auto-generated method stub
		
	}

	public void updateCars(Cars car) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCars(Cars car) {
		// TODO Auto-generated method stub
		
	}

}
