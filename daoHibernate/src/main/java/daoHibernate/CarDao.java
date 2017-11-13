package daoHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import beans.Car;

public class CarDao {

	HibernateUtils instance = HibernateUtils.getInstance();
	Session curentSession;
	Transaction curentTransaction;

	public List<Car> getAll() {
		curentSession = instance.getSessionFactory().getCurrentSession();
		curentTransaction = curentSession.beginTransaction();
		List<Car> result = curentSession.createCriteria(Car.class).list();
		curentTransaction.commit();
		
		return result;
	}

	public Car getById(Integer id) {
		curentSession = instance.getSessionFactory().getCurrentSession();
		curentTransaction = curentSession.beginTransaction();
		Car car = (Car) curentSession.createCriteria(Car.class).add(Restrictions.idEq(id)).uniqueResult();
		curentTransaction.commit();
		
		return car;
	}

	public void deleteById(Integer id) {
		curentSession = instance.getSessionFactory().getCurrentSession();
		curentTransaction = curentSession.beginTransaction();
		Car car = (Car) curentSession.createCriteria(Car.class).add(Restrictions.idEq(id)).uniqueResult();

		if (car != null) {
			curentSession.delete(car);
		}
		
		curentTransaction.commit();
	}

	public void save(Car car) {
		curentSession = instance.getSessionFactory().getCurrentSession();
		curentTransaction = curentSession.beginTransaction();
		curentSession.saveOrUpdate(car);
		curentTransaction.commit();
	}
}
