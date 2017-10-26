package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Cars;
import com.Entity;

import dao.AbstractDao;

public class CarsDao extends AbstractDao {

	public CarsDao() {
		super("cars");
	}

//	MySQLConector connector = MySQLConector.getInstance();

	/** Получаем все строки таблицы shops */

	// public ArrayList<Cars> getAllCars() {
	// Connection con = connector.getConnection();
	// ArrayList<Cars> carsList = new ArrayList<Cars>();
	// Statement selectCars;
	// try {
	// selectCars = con.createStatement();
	// String query = "Select * from cars;";
	// ResultSet result = selectCars.executeQuery(query);
	//
	// while (result.next()) {
	// int id = result.getInt("id");
	// String model = result.getString("model");
	// int price = result.getInt("price");
	// Cars car = new Cars(id, model, price, null);
	// carsList.add(car);
	// }
	// selectCars.close();
	// } catch (SQLException e) {
	// System.out.println("Bad select query");
	// }
	// return carsList;
	// }

	/** Возвращает конретную строку по id */

	// public Cars getCar(int id) {
	// Cars car = null;
	// Connection con = connector.getConnection();
	//
	// try {
	// String query = "Select * from cars where id = ?;";
	// PreparedStatement selectCars = con.prepareStatement(query);
	// selectCars.setInt(1, id);
	// ResultSet result = selectCars.executeQuery();
	// result.next();
	// car = new Cars(result.getInt("id"), result.getString("model"),
	// result.getInt("price"), null);
	//
	// selectCars.close();
	// } catch (SQLException e) {
	// System.out.println("Bad select query");
	// e.printStackTrace();
	// }
	// return car;
	// }

	/** Сохраняет объект в базе в качестве новой записи (вставка) */

//	public void insertCars(Cars car) {
//		Connection con = connector.getConnection();
//		String query;
//		if (car.getShopID() != null) {
//			query = "Insert into cars (model,price,shops_id)values(?,?,?);";
//		} else {
//			query = "Insert into cars (model,price)values(?,?);";
//		}
//
//		try {
//			PreparedStatement pstmt = con.prepareStatement(query);
//			pstmt.setString(1, car.getModel());
//			pstmt.setInt(2, car.getPrice());
//			if (car.getShopID() != null) {
//				pstmt.setInt(3, car.getShopID().getId());
//			}
//			pstmt.executeUpdate();
//			System.out.println("insert into cars complit");
//		} catch (SQLException e) {
//			System.out.println("bad insert query");
//		}
//
//	}

	/** Сохраняет изменения объекта в базе */

//	public void updateCars(Cars car) {
//		Connection con = connector.getConnection();
//		String query;
//		PreparedStatement pstmt;
//		try {
//			if (car.getShopID() != null) {
//				query = "Update cars set model=?, price=?, shops_id=? where id=?;";
//				pstmt = con.prepareStatement(query);
//				pstmt.setString(1, car.getModel());
//				pstmt.setInt(2, car.getPrice());
//				pstmt.setInt(3, car.getShopID().getId());
//				pstmt.setInt(4, car.getId());
//
//			} else {
//				query = "Update cars set model=?, price=? where id=?;";
//				pstmt = con.prepareStatement(query);
//				pstmt.setString(1, car.getModel());
//				pstmt.setInt(2, car.getPrice());
//				pstmt.setInt(3, car.getId());
//			}
//
//			pstmt.executeUpdate();
//			System.out.println("cars is updated");
//		} catch (SQLException e) {
//			System.out.println("bad update query");
//		}
//
//	}

	/** Удаляет объект из базы по id */

//	public void deleteCars(int id) {
//		Connection con = connector.getConnection();
//		String query = "Delete from cars where id = ?;";
//		try {
//			PreparedStatement stmt = con.prepareStatement(query);
//			stmt.setInt(1, id);
//			stmt.executeUpdate();
//			System.out.println("car is deleted");
//		} catch (SQLException e) {
//			System.out.println("bad delete query");
//		}
//
//	}

	@Override
	protected Entity parseEntity(ResultSet rs) {
		Cars car = null;
		try {
			int id = rs.getInt("id");
			String model = rs.getString("model");
			int price = rs.getInt("price");
			car = new Cars(id, model, price, null);
		} catch (SQLException e) {
			System.out.println("problem in parseEntity");
		}
		return car;
	}

	@Override
	protected String createSelectQuery(int id) {
		return "Select * from cars where id=" + id + ";";
	}

	@Override
	protected String createInsertQuery(Entity entity) {
		Cars car = (Cars) entity;
		String query;
		if (car.getShopID() != null) {
			query = "Insert into cars (model,price,shops_id)values("
					+ car.getModel() + "," + car.getPrice() + ","
					+ car.getShopID().getId() + ");";
		} else {
			query = "Insert into cars (model,price)values(" + car.getModel()
					+ "," + car.getPrice() + ");";
		}
		return query;
	}

	@Override
	protected String createUpdateQuery(Entity entity) {

		String query;
		Cars car = (Cars) entity;
		if (car.getShopID() != null) {
			query = "Update cars set model=" + car.getModel() + ", price="
					+ car.getPrice() + ", shops_id=" + car.getShopID().getId()
					+ " where id=" + car.getId() + ";";

		} else {
			query = "Update cars set model=" + car.getModel() + ", price="
					+ car.getPrice() + " where id=" + car.getId() + ";";
		}
		return query;
	}

	@Override
	protected String createDeleteQuery(int id) {

		return "Delete from cars where id = " + id + ";";
	}

}
