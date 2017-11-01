package main.java.interfaces;

import java.util.ArrayList;

import main.java.beans.Shops;

public interface ShopsDao {

	/** Получаем все строки таблицы shops */
	public ArrayList<Shops> getAllShops();

	/** Возвращает конретную строку по id */
	public Shops getShop(int id);

	/** Сохраняет объект в базе в качестве новой записи (вставка) */
	public void insertShops(Shops shop);

	/** Сохраняет изменения объекта в базе */
	public void updateShops(Shops shop);

	/** Удаляет объект из базы по id */
	public void deleteShops(int id);
}
