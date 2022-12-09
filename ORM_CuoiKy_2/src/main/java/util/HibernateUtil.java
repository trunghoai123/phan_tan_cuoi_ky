package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
 
import entity.Department; 
import entity.HourlyStaff;
import entity.Profile;
import entity.Project;
import entity.SalariedStaff;
import entity.Staff;
import entity.StaffOfProject;
import entity.StaffOfProjectPK; 

public class HibernateUtil {

	private static HibernateUtil instance = null;
	
	private SessionFactory sessionFactory;
	private HibernateUtil() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(Department.class)
				.addAnnotatedClass(HourlyStaff.class)
				.addAnnotatedClass(Project.class)
				.addAnnotatedClass(Profile.class)
				.addAnnotatedClass(SalariedStaff.class)
				.addAnnotatedClass(Staff.class)
				.addAnnotatedClass(StaffOfProject.class)
				.addAnnotatedClass(StaffOfProjectPK.class)
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
//
//	private HibernateUtil() {
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//				.configure()
//				.build();
//
//		Metadata metadata = new MetadataSources(serviceRegistry)
//				.addAnnotatedClass(Employee.class)
//				.addAnnotatedClass(Assignment.class)
//				.addAnnotatedClass(Project.class)
//				.getMetadataBuilder()
//				.build();
//
//		sessionFactory = metadata
//				.getSessionFactoryBuilder()
//				.build();
//
//	} 

}	
