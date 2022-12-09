package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import entity.Assignment;
import entity.Employee;
import entity.Project;

public class HibernateUtil {

	private static HibernateUtil instance = null;
	
	private SessionFactory sessionFactory;

	private HibernateUtil() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure()
				.build();

		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Assignment.class)
				.addAnnotatedClass(Project.class)
				.getMetadataBuilder()
				.build();

		sessionFactory = metadata
				.getSessionFactoryBuilder()
				.build();
	}

	public synchronized static HibernateUtil getInstance() {
		if(instance == null)
			instance = new HibernateUtil();
		return instance;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}	
