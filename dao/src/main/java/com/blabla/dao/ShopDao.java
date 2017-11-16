package com.blabla.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.blabla.beans.AEntity;
import com.blabla.beans.Shop;



public class ShopDao extends AbstractDao {

	public ShopDao() {
		super("shops");
	}

	@Override
	protected AEntity parseEntity(ResultSet rs) {
		Shop shop = null;
		try {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String adress = rs.getString("adress");
			shop = new Shop(id, name, adress);
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
	protected String createInsertQuery(AEntity entity) {
		Shop shop = (Shop) entity;
		String q = "Insert into shops (name,adress)values('" + shop.getName()
				+ "','" + shop.getAdress() + "');";
		System.out.println(q);
		return q;
	}

	@Override
	protected String createUpdateQuery(AEntity entity) {
		Shop shop = (Shop) entity;
		return "Update shops set name='" + shop.getName() + "', adress='"
				+ shop.getAdress() + "' where id=" + shop.getId() + ";";
	}

	@Override
	protected String createDeleteQuery(int id) {
		return "Delete from shops where id = " + id + ";";
	}
}
