package daoHibernate;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import beans.Shop;

public class ShopDao {
	private static final Logger log = LogManager.getLogger(ShopDao.class);
	HibernateUtils instance = HibernateUtils.getInstance();

	public List<Shop> getAll() {
		List<Shop> result = null;
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			result = curentSession.createCriteria(Shop.class).list();
			curentTransaction.commit();
			log.info("Vdhistko v pozhondku");
		} catch (Exception e) {
			log.error(e);
		}

		return result;
	}

	public Shop getById(Integer id) {
		Shop shop = null;
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			List<Shop> list = curentSession.createCriteria(Shop.class).add(Restrictions.idEq(id)).list();
			curentTransaction.commit();
			shop = list.get(0);
			log.info("Vdhistko v pozhondku");
		} catch (Exception e) {
			log.error(e);
		}
		return shop;
	}

	public void deleteById(Integer id) {
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			Shop shop = (Shop) curentSession.createCriteria(Shop.class).add(Restrictions.idEq(id)).uniqueResult();
			if (shop != null) {
				curentSession.delete(shop);
				log.info("Deleted");
			} else {
				log.info("No such entity");
			}
			curentTransaction.commit();
		} catch (Exception e) {
			log.error(e);
		}

	}

	public void save(Shop shop) {
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			curentSession.saveOrUpdate(shop);
			curentTransaction.commit();
			log.info("Saved");
		}catch(Exception e) {
			log.error(e);
		}

	}

}
