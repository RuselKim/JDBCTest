package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.Entity;
import com.MySQLConector;

public abstract class AbstractDao {
	private final MySQLConector connector = MySQLConector.getInstance();
	private String tName;
	private String getAllQuery = "Select * from " + tName + ";";

	protected AbstractDao(String tName) {
		this.tName = tName;
	}

	private Connection getCon() {
		Connection con = connector.getConnection();
		return con;
	}

	protected abstract Entity parseEntity(ResultSet rs);

	/** Получаем все строки таблицы */

	public List<Entity> getAll() {

		List<Entity> entities = null;
		try (PreparedStatement ps = getCon().prepareStatement(getAllQuery)) {
			ResultSet rs = ps.executeQuery();
			entities = new ArrayList<Entity>();
			while (rs.next()) {
				entities.add(parseEntity(rs));
			}
		} catch (SQLException e) {
			System.out.println("Bad query");
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

	protected abstract String createSelectQuery(int id);

	/** Сохраняет объект в базе в качестве новой записи (вставка) */

	public void insertEntity(Entity entity) {
		try (PreparedStatement pstmt = getCon().prepareStatement(
				createInsertQuery(entity))) {
			pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("Bad insert query");
		}
	}

	protected abstract String createInsertQuery(Entity entity);

	/** Сохраняет изменения объекта в базе */

	public void updateEntity(Entity entity) {
		try (PreparedStatement pstmt = getCon().prepareStatement(
				createUpdateQuery(entity))) {
			pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("Bad update query");
		}
	}

	protected abstract String createUpdateQuery(Entity entity);

	/** Удаляет объект из базы по id */

	public void deleteEntity(int id) {
		try (Statement pstmt = getCon().createStatement(
				)) {
			pstmt.executeQuery(createDeleteQuery(id));
		} catch (SQLException e) {
			System.out.println("Bad delete query");
		}
	}

	protected abstract String createDeleteQuery(int id);

}
