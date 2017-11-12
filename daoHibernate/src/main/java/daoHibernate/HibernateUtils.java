package daoHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {
	private static HibernateUtils instance;
	private SessionFactory sessionFactory;
	
	public HibernateUtils() {
	}
	
	public static HibernateUtils getInstance() {
		if (instance == null) {
			instance = new HibernateUtils();
		}
		return instance;
	}
	
	
	private SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
		
		return configuration.buildSessionFactory(serviceRegistry);
	}
	
	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}
	
}
