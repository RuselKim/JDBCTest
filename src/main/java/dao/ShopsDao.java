package main.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.beans.Entity;
import main.java.beans.Shops;

public class ShopsDao extends AbstractDao {

	public ShopsDao() {
		super("shops");
	}

	@Override
	protected Entity parseEntity(ResultSet rs) {
		Shops shop = null;
		try {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String adress = rs.getString("adress");
			shop = new Shops(id, name, adress);
		} catch (SQLException e) {
			System.out.println("problem in parseEntity");
		}
		return shop;
	}

	@Override
	protected String createSelectQuery(int id) {
		return "Select * from shops where id = " + id + ";";
	}

	@Override
	protected String createInsertQuery(Entity entity) {
		Shops shop = (Shops) entity;
		String q = "Insert into shops (name,adress)values('" + shop.getName()
				+ "','" + shop.getAdress() + "');";
		System.out.println(q);
		return q;
	}

	@Override
	protected String createUpdateQuery(Entity entity) {
		Shops shop = (Shops) entity;
		return "Update shops set name='" + shop.getName() + "', adress='"
				+ shop.getAdress() + "' where id=" + shop.getId() + ";";
	}

	@Override
	protected String createDeleteQuery(int id) {
		return "Delete from shops where id = " + id + ";";
	}
}
