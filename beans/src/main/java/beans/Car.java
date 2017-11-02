package beans;


public class Car extends Entity {

	public Car(String model, int price, Shop shops) {

		setModel(model);
		setPrice(price);
		setShop(shops);
	}

	public Car(int id, String model, int price, Shop shops) {
		setId(id);
		setModel(model);
		setPrice(price);
		setShop(shops);
	}

	private int id;
	private String model;
	private int price;
	private Shop shop;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
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
