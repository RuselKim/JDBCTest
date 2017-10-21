package com;

import java.sql.Connection;

import mysql.MySqlCarsDao;
import mysql.MySqlShopsDao;

public class Main {

	public static void main(String[] args) {
		
		MySqlCarsDao carsDao = new MySqlCarsDao();
		MySqlShopsDao shopsDao = new MySqlShopsDao();
		Shops avtomag = new Shops("avtomag","Pushkina 2");
		Shops razvoluhi = new Shops("razvoluhi","Centralnaya 32");
		Cars a8 = new Cars("audi a8", 12000, avtomag);
		Cars q7 = new Cars("audi q7", 20000, null);
		Cars x5 = new Cars("BMW x5", 25000,razvoluhi);
		
//		shopsDao.insertShops(avtomag);
//		shopsDao.insertShops(razvoluhi);
		//carsDao.insertCars(a8);
		//carsDao.insertCars(q7);
		//carsDao.insertCars(x5);
		carsDao.deleteCars(1);
		
		System.out.println(shopsDao.getAllShops().size());
		System.out.println(carsDao.getAllCars().size());
		
	
		
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
