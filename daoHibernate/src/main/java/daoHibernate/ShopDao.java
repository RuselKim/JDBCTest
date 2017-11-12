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
		curentSession = instance.getSessionFactory().openSession();
		List<Shop> result = curentSession.createCriteria(Shop.class).list();
		return result;
	}

	public Shop getById(Integer id) {
		curentSession = instance.getSessionFactory().openSession();
		Shop shop = (Shop) curentSession.createCriteria(Shop.class).add(Restrictions.idEq(id)).uniqueResult();

		return shop;
	}

	public void deleteById(Integer id) {
		curentSession = instance.getSessionFactory().openSession();
		Shop shop = (Shop) curentSession.createCriteria(Shop.class).add(Restrictions.idEq(id)).uniqueResult();
		System.out.println(shop.getId());
		if (shop != null) {
			curentSession.delete(shop);
		}
	}

	public void save(Shop shop) {
		curentSession = instance.getSessionFactory().openSession();
		curentSession.saveOrUpdate(shop);
	}

}
