package com;

import dao.CarsDao;
import dao.ShopsDao;

public class Main {

	public static void main(String[] args) {
		
		CarsDao carsDao = new CarsDao();
		ShopsDao shopsDao = new ShopsDao();
		Shops avtomag = new Shops("avtomag","Pushkina 2");
		Shops razvoluhi = new Shops("razvoluhi","Centralnaya 32");
		Cars a8 = new Cars("audi a8", 12000, avtomag);
		Cars q7 = new Cars("audi q7", 20000, null);
		Cars x5 = new Cars("BMW x5", 25000,razvoluhi);
		
		shopsDao.insertEntity(avtomag);
//		shopsDao.insertEntity(razvoluhi);
//		carsDao.insertEntity(a8);
//		carsDao.insertEntity(q7);
//		carsDao.insertEntity(x5);
//		carsDao.deleteCars(1);
//		shopsDao.deleteShops(15);
//		Cars car = (Cars) carsDao.getEntityById(2);
//		System.out.println(car.getModel());
//		car.setModel("a88");
//		carsDao.updateCars(car);
//		Shops shop = (Shops)shopsDao.getEntityById(17);
//		System.out.println(shop.getAdress());
		
		
//		System.out.println(shopsDao.getAllShops().size());
//		System.out.println(carsDao.getAll().size());
//		
	
		
//		DBController controller = new DBController();
//		Shops avtomag = new Shops("avtomag","Pushkina 2");
//		Shops razvoluhi = new Shops("razvoluhi","Centralnaya 32");
//		Cars a8 = new Cars("audi a8", 12000, avtomag);
//		Cars q7 = new Cars("audi q7", 20000, null);
//		Cars x5 = new Cars("BMW x5", 25000,razvoluhi);
//		
//		controller.insertShops(razvoluhi);
//		controller.insertShops(avtomag);
//		
//		controller.insertCars(a8);
//		controller.insertCars(q7);
//		controller.insertCars(x5);
//			
//		System.out.println(controller.selectCars().size());
//		System.out.println("__________");
//		System.out.println(controller.selectShops());
//		
//		Conector.closeConnection();
	}

}
