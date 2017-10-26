package dao;

import java.sql.Connection;

/** фабрика объектов для работ с базами данных*/
public interface DaoFactory {
	
	/** проверяет наличие подключения к базе и при его отсутствии вызывает createConnection()*/
	public Connection getConnection();
	

	public ShopsDao getShopsDao(Connection connection);
	
	
	public CarsDao getCarsDao(Connection connection);
	
	
}
