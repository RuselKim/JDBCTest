package daoHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import beans.Car;
import beans.Shop;

public class ShopDao {

	HibernateUtils instance = HibernateUtils.getInstance();
	Session curentSession;
	Transaction curentTransaction;

	public List<Shop> getAll() {
		curentSession = instance.getSessionFactory().getCurrentSession();
		curentTransaction = curentSession.beginTransaction();
		List<Shop> result = curentSession.createCriteria(Shop.class).list();
		curentTransaction.commit();
		
		return result;
	}

	public Shop getById(Integer id) {
		curentSession = instance.getSessionFactory().getCurrentSession();
		curentTransaction = curentSession.beginTransaction();
		Shop shop = (Shop) curentSession.createCriteria(Shop.class).add(Restrictions.idEq(id)).uniqueResult();
		curentTransaction.commit();

		return shop;
	}

	public void deleteById(Integer id) {
		curentSession = instance.getSessionFactory().getCurrentSession();
		curentTransaction = curentSession.beginTransaction();
		Shop shop = (Shop) curentSession.createCriteria(Shop.class).add(Restrictions.idEq(id)).uniqueResult();
		if (shop != null) {
			curentSession.delete(shop);
		}else {
			System.out.println("there is no such shop");
		}
		curentTransaction.commit();
		
	}

	public void save(Shop shop) {
		
		curentSession = instance.getSessionFactory().getCurrentSession();
		curentTransaction = curentSession.beginTransaction();
		curentSession.saveOrUpdate(shop);
		curentTransaction.commit();
	}

}
