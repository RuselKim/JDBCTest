package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Cars;
import com.MySQLConector;

import dao.CarsDao;

public class MySqlCarsDao implements CarsDao {

	MySQLConector connector = MySQLConector.getInstance();

	
	/** Получаем все строки таблицы shops*/

	public ArrayList<Cars> getAllCars() {
		Connection con = connector.getConnection();
		ArrayList<Cars> carsList = new ArrayList<Cars>();
		Statement selectCars;
		try {
			selectCars = con.createStatement();
			String query = "Select * from cars;";
			ResultSet result = selectCars.executeQuery(query);

			while (result.next()) {
				int id = result.getInt("id");
				String model = result.getString("model");
				int price = result.getInt("price");
				Cars car = new Cars(id, model, price, null);
				carsList.add(car);
			}
			selectCars.close();
		} catch (SQLException e) {
			System.out.println("Bad select query");
		}
		return carsList;
	}

	
	/** Возвращает конретную строку по id*/

	public Cars getCar(int id) {
		Cars car = null;
		Connection con = connector.getConnection();

		try {
			String query = "Select * from cars where id = ?;";
			PreparedStatement selectCars = con.prepareStatement(query);
			selectCars.setInt(1, id);
			ResultSet result = selectCars.executeQuery();
			result.next();
			car = new Cars(result.getInt("id"), result.getString("model"),
					result.getInt("price"),null);

			selectCars.close();
		} catch (SQLException e) {
			System.out.println("Bad select query");
			e.printStackTrace();
		}
		return car;
	}

	
	/** Сохраняет объект в базе в качестве новой записи (вставка)*/

	public void insertCars(Cars car) {
		Connection con = connector.getConnection();
		String query;
		if (car.getShopID() != null){
			query = "Insert into cars (model,price,shops_id)values(?,?,?);";
		}else{
			query = "Insert into cars (model,price)values(?,?);";
		}
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, car.getModel());
			pstmt.setInt(2, car.getPrice());
			if (car.getShopID() != null) {
				pstmt.setInt(3, car.getShopID().getId());
			}
			pstmt.executeUpdate();
			System.out.println("insert into cars complit");
		} catch (SQLException e) {
			System.out.println("bad insert query");
		}

	}

	
	/** Сохраняет изменения объекта в базе*/

	public void updateCars(Cars car) {
		Connection con = connector.getConnection();
		String query;
		PreparedStatement pstmt;
		try {
		if (car.getShopID() != null){
			query = "Update cars set model=?, price=?, shops_id=? where id=?;";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, car.getModel());
			pstmt.setInt(2, car.getPrice());
			pstmt.setInt(3, car.getShopID().getId());
			pstmt.setInt(4, car.getId());
				
		}else{
			query = "Update cars set model=?, price=? where id=?;";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, car.getModel());
			pstmt.setInt(2, car.getPrice());
			pstmt.setInt(3, car.getId());
		}

			pstmt.executeUpdate();
			System.out.println("cars is updated");
		} catch (SQLException e) {
			System.out.println("bad update query");
		}

	}

	
	/** Удаляет объект из базы по id*/

	public void deleteCars(int id) {
		Connection con = connector.getConnection();
		String query = "Delete from cars where id = ?;";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1,id);
			stmt.executeUpdate();
			System.out.println("car is deleted");
		} catch (SQLException e) {
			System.out.println("bad delete query");
		}

	}

}
