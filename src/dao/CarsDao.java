package dao;

import java.util.ArrayList;
import java.util.Map;

import com.Cars;

public interface CarsDao {

	public ArrayList getAllCars();
	
	public Cars getCar(int id);
	
	public void insertCars (Cars car);
	
	public void updateCars(Cars car);
	
	public void deleteCars(Cars car);
}
