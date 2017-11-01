package main.java.runable;

import main.java.beans.MySQLConector;
import main.java.dao.CarsDao;
import main.java.dao.ShopsDao;

public class Main {

	public static void main(String[] args) {

		CarsDao carsDao = new CarsDao();
		ShopsDao shopsDao = new ShopsDao();
		// Shops avtomag = new Shops("avtomag","Pushkina 2");
		// Shops razvoluhi = new Shops("razvoluhi","Centralnaya 32");
		// Cars a8 = new Cars("audi a8", 12000, avtomag);
		// Cars q7 = new Cars("audi q7", 20000, null);
		// Cars x5 = new Cars("BMW x5", 25000,razvoluhi);

		System.out.println(shopsDao.getAll().size());
		System.out.println(carsDao.getAll().size());

		MySQLConector.closeConnection();
	}

}
