package com;

public class Main {

	public static void main(String[] args) {
		DBController controller = new DBController();
		Shops avtomag = new Shops("avtomag","Pushkina 2");
		Shops razvoluhi = new Shops("razvoluhi","Centralnaya 32");
		Cars a8 = new Cars("audi a8", 12000, avtomag);
		Cars q7 = new Cars("audi q7", 20000, null);
		Cars x5 = new Cars("BMW x5", 25000,razvoluhi);
		
		controller.insertShops(razvoluhi);
		controller.insertShops(avtomag);
		
		controller.insertCars(a8);
		controller.insertCars(q7);
		controller.insertCars(x5);
			
		System.out.println(controller.selectCars().size());
		System.out.println("__________");
		System.out.println(controller.selectShops());
		
		Conector.closeConnection();
	}

}
