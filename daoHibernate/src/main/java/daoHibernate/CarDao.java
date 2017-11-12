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
		curentSession = instance.getSessionFactory().openSession();
		List<Car> result = curentSession.createCriteria(Car.class).list();
		return result;
	}

	public Car getById(Integer id) {
		curentSession = instance.getSessionFactory().openSession();
		Car car = (Car) curentSession.createCriteria(Car.class).add(Restrictions.idEq(id)).uniqueResult();

		return car;
	}

	public void deleteById(Integer id) {
		curentSession = instance.getSessionFactory().openSession();
		Car car = (Car) curentSession.createCriteria(Car.class).add(Restrictions.idEq(id)).uniqueResult();

		if (car != null) {
			curentSession.delete(car);
		}
	}

	public void save(Car car) {
		curentSession = instance.getSessionFactory().openSession();
		curentSession.saveOrUpdate(car);
	}
}
