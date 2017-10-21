package dao;

import java.util.ArrayList;


import com.Cars;

public interface CarsDao {

	public ArrayList<Cars> getAllCars();
	
	public Cars getCar(int id);
	
	public void insertCars (Cars car);
	
	public void updateCars(Cars car);
	
	public void deleteCars(int id);
}
