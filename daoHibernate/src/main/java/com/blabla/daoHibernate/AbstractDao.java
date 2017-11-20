package com.blabla.daoHibernate;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AbstractDao {

	HibernateUtils instance = HibernateUtils.getInstance();
	private static final Logger log = LogManager.getLogger();

	public <T> List<T> getAll(Class<T> type) {
		List<T> result = null;
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			result = curentSession.createCriteria(type).list();
			curentTransaction.commit();
			log.info("SUCCESS");
		} catch (Exception e) {
			log.error(e);
		}
		return result;

	}

	public <T> T getById(Class<T> type, Integer id) {
		T obj = null;
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			List<T> list = curentSession.createCriteria(type).add(Restrictions.eq("id", id)).list();
			curentTransaction.commit();
			obj = list.get(0);
			log.info("SUCCESS");
		} catch (Exception e) {
			log.error(e);
		}

		return obj;
	}

	public <T> void deleteById(Class<T> type, Integer id) {
		T obj = null;
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			obj = (T) curentSession.createCriteria(type).add(Restrictions.eq("id", id)).uniqueResult();

			if (obj != null) {
				curentSession.delete(obj);
				log.info("Deleted");
			} else {
				log.info("No such entity");
			}

			curentTransaction.commit();
		} catch (Exception e) {
			log.error(e);
		}
	}

	public <T> void save(T obj) {
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			curentSession.saveOrUpdate(obj);
			curentTransaction.commit();
			log.info("Saved");
		} catch (Exception e) {
			log.error(e);
		}
	}

	public <T> T getByIdWithShop(Class<T> type, Integer id) {
		T obj = null;
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			List<T> list = curentSession.createCriteria(type).createAlias("shop", "id").add(Restrictions.idEq(id))
					.list();
			curentTransaction.commit();
			obj = list.get(0);
			log.info("SUCCESS");
		} catch (Exception e) {
			log.error(e);
		}

		return obj;
	}
}
