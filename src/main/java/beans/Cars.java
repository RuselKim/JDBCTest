package main.java.beans;


public class Cars extends Entity {

	public Cars(String model, int price, Shops shops) {

		setModel(model);
		setPrice(price);
		setShop(shops);
	}

	public Cars(int id, String model, int price, Shops shops) {
		setId(id);
		setModel(model);
		setPrice(price);
		setShop(shops);
	}

	private int id;
	private String model;
	private int price;
	private Shops shop;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Shops getShop() {
		return shop;
	}

	public void setShop(Shops shop) {
		this.shop = shop;
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
