package main.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.beans.Cars;
import main.java.beans.Entity;

public class CarsDao extends AbstractDao {

	public CarsDao() {
		super("cars");
	}

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
		if (car.getShop() != null) {
			query = "Insert into cars (model,price,shops_id)values('"
					+ car.getModel() + "'," + car.getPrice() + ","
					+ car.getShop().getId() + ");";
		} else {
			query = "Insert into cars (model,price)values('" + car.getModel()
					+ "'," + car.getPrice() + ");";
		}
		return query;
	}

	@Override
	protected String createUpdateQuery(Entity entity) {

		String query;
		Cars car = (Cars) entity;
		if (car.getShop() != null) {
			query = "Update cars set model='" + car.getModel() + "', price="
					+ car.getPrice() + ", shops_id=" + car.getShop().getId()
					+ " where id=" + car.getId() + ";";

		} else {
			query = "Update cars set model='" + car.getModel() + "', price="
					+ car.getPrice() + " where id=" + car.getId() + ";";
		}
		return query;
	}

	@Override
	protected String createDeleteQuery(int id) {

		return "Delete from cars where id = " + id + ";";
	}

}
