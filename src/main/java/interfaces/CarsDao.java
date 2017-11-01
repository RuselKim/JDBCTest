package main.java.interfaces;

import java.util.ArrayList;

import main.java.beans.Cars;

public interface CarsDao {

	/** Получаем все строки таблицы shops */
	public ArrayList<Cars> getAllCars();

	/** Возвращает конретную строку по id */
	public Cars getCar(int id);

	/** Сохраняет объект в базе в качестве новой записи (вставка) */
	public void insertCars(Cars car);

	/** Сохраняет изменения объекта в базе */
	public void updateCars(Cars car);

	/** Удаляет объект из базы по id */
	public void deleteCars(int id);
}
