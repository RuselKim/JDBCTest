package runer;

import beans.AEntity;
import beans.Car;
import beans.Shop;
import daoHibernate.CarDao;
import daoHibernate.ShopDao;

public class Main {

	public static void main(String[] args) {

		CarDao carsDao = new CarDao();
		ShopDao shopsDao = new ShopDao();
//		 Shop avtomag = new Shop("avtomag","Pushkina 2");
//		 Shop razvoluhi = new Shop("razvoluhi","Centralnaya 32");
//		 Car a8 = new Car("audi a8", 12000, avtomag);
//		 Car q7 = new Car("audi q7", 20000, null);
//		 Car x5 = new Car("BMW x5", 25000,razvoluhi);

//		shopsDao.save(razvoluhi);
//		shopsDao.deleteById(20);
		
//		 carsDao.save(q7);
//		 carsDao.deleteById(3);
		 
//		print(carsDao.getById(2));
//		print(shopsDao.getById(21));

//		for (Shop s : shopsDao.getAll()) {
//			print(s);
//		}
		
//		for (Car s : carsDao.getAll()) {
//			print(s);
//		}
		
//		shopsDao.deleteById(20);

		Car vbn = carsDao.getById(2);
		print(vbn.getShop());
	}
	
	public static void print (AEntity entity) {
		Class<? extends AEntity> c = entity.getClass();
		if(c.getSimpleName().toString().equals("Car")) {
			Car car = (Car)entity;
			System.out.println("id = " + car.getId());
			System.out.println("model = " + car.getModel());
			System.out.println("price = " + car.getPrice());
			System.out.println("shop = " + car.getShop().getName());
			System.out.println(".................");
		}else if (c.getSimpleName().toString().equals("Shop")) {
			Shop shop = (Shop) entity;
			System.out.println("id = " + shop.getId());
			System.out.println("name = " + shop.getName());
			System.out.println("adress = " + shop.getAdress());
			System.out.println(".................");
		}
	}

}
