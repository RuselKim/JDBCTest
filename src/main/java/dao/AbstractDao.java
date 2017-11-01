package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.beans.Entity;
import main.java.beans.MySQLConector;

public abstract class AbstractDao {
	private final MySQLConector connector = MySQLConector.getInstance();
	private String tName;
	private String getAllQuery = "Select * from ";

	protected AbstractDao(String tName) {
		this.tName = tName;
	}

	private Connection getCon() {
		Connection con = connector.getConnection();
		return con;
	}

	private String createGetAllQuery() {
		return getAllQuery + tName;
	}

	protected abstract Entity parseEntity(ResultSet rs);

	/** Получаем все строки таблицы */

	public List<Entity> getAll() {

		List<Entity> entities = new ArrayList<Entity>();
		try (PreparedStatement ps = getCon().prepareStatement(
				createGetAllQuery())) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				entities.add(parseEntity(rs));
			}
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
		return entities;
	}

	/** Возвращает конретную строку по id */

	public Entity getEntityById(int id) {
		Entity entity = null;
		try (PreparedStatement selectEntity = getCon().prepareStatement(
				createSelectQuery(id));) {
			ResultSet rs = selectEntity.executeQuery();
			rs.next();
			entity = parseEntity(rs);

		} catch (SQLException e) {
			System.out.println("Bad select query");
		}
		return entity;
	}

	/** Генерирует SELECT выражение с нужным id */

	protected abstract String createSelectQuery(int id);

	/** Сохраняет объект в базе в качестве новой записи (вставка) */

	public void insertEntity(Entity entity) {
		try (PreparedStatement pstmt = getCon().prepareStatement(
				createInsertQuery(entity))) {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Bad insert query");
			e.printStackTrace();
		}
	}

	/** Генерирует INSERT выражение для выбранного объекта */
	
	protected abstract String createInsertQuery(Entity entity);

	/** Сохраняет изменения объекта в базе */

	public void updateEntity(Entity entity) {
		try (PreparedStatement pstmt = getCon().prepareStatement(
				createUpdateQuery(entity))) {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Bad update query");
		}
	}

	/** Генерирует UPDATE выражение для выбранного объекта */
	
	protected abstract String createUpdateQuery(Entity entity);

	/** Удаляет объект из базы по id */

	public void deleteEntity(int id) {
		try (Statement pstmt = getCon().createStatement()) {
			pstmt.executeUpdate(createDeleteQuery(id));
		} catch (SQLException e) {
			System.out.println("Bad delete query");
			e.printStackTrace();
		}
	}

	/** Генерирует DELETE выражение с нужным id */
	
	protected abstract String createDeleteQuery(int id);

}
