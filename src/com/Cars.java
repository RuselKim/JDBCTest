package com;

import com.Entity;

public class Cars extends Entity {

	public Cars(String model, int price, Shops shops_id) {

		setModel(model);
		setPrice(price);
		setShopID(shops_id);
	}

	public Cars(int id, String model, int price, Shops shops_id) {
		setId(id);
		setModel(model);
		setPrice(price);
		setShopID(shops_id);
	}

	private int id;
	private String model;
	private int price;
	private Shops shopID;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Shops getShopID() {
		return shopID;
	}

	public void setShopID(Shops shopID) {
		this.shopID = shopID;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;

	}

}
