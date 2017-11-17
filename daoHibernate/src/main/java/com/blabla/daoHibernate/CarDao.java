package com.blabla.daoHibernate;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.blabla.beans.Car;

public class CarDao {

	HibernateUtils instance = HibernateUtils.getInstance();
	private static final Logger log = LogManager.getLogger(CarDao.class);

	public List<Car> getAll() {
		List<Car> result = null;
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			result = curentSession.createCriteria(Car.class).list();
			curentTransaction.commit();
			log.info("Vdhistko v pozhondku");
		} catch (Exception e) {
			log.error(e);
		}
		return result;

	}

	public Car getById(Integer id) {
		Car car = null;
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			List<Car> list = curentSession.createCriteria(Car.class).add(Restrictions.idEq(id)).list();
			curentTransaction.commit();
			car = list.get(0);
			log.info("Vdhistko v pozhondku");
		} catch (Exception e) {
			log.error(e);
		}

		return car;
	}
	
	public Car getByIdWithShop(Integer id) {
		Car car = null;
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			List<Car> list = curentSession.createCriteria(Car.class).createAlias("shop", "id").add(Restrictions.idEq(id)).list();
			curentTransaction.commit();
			car = list.get(0);
			log.info("Vdhistko v pozhondku");
		} catch (Exception e) {
			log.error(e);
		}

		return car;
	}

	public void deleteById(Integer id) {
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			Car car = (Car) curentSession.createCriteria(Car.class).add(Restrictions.idEq(id)).uniqueResult();

			if (car != null) {
				curentSession.delete(car);
				log.info("Deleted");
			} else {
				log.info("No such entity");
			}

			curentTransaction.commit();
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void save(Car car) {
		try {
			Session curentSession = instance.getSessionFactory().getCurrentSession();
			Transaction curentTransaction = curentSession.beginTransaction();
			curentSession.saveOrUpdate(car);
			curentTransaction.commit();
			log.info("Saved");
		} catch (Exception e) {
			log.error(e);
		}
	}
}
