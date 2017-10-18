package dao;

import java.util.ArrayList;


import com.Shops;

public interface ShopsDao {

	public ArrayList getAllShops();
	
	public Shops getShop(int id);
	
	public void insertShops (Shops shop);
	
	public void updateShops(Shops shop);
	
	public void deleteShops(Shops shop);
}
