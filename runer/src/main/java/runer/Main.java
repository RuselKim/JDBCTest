package runer;

import utils.DbConector;
import dao.CarDao;
import dao.ShopDao;



public class Main {

	public static void main(String[] args) {

		CarDao carsDao = new CarDao();
		ShopDao shopsDao = new ShopDao();
		// Shops avtomag = new Shops("avtomag","Pushkina 2");
		// Shops razvoluhi = new Shops("razvoluhi","Centralnaya 32");
		// Cars a8 = new Cars("audi a8", 12000, avtomag);
		// Cars q7 = new Cars("audi q7", 20000, null);
		// Cars x5 = new Cars("BMW x5", 25000,razvoluhi);

		System.out.println(shopsDao.getAll().size());
		System.out.println(carsDao.getAll().size());

		DbConector.closeConnection();
	}

}
