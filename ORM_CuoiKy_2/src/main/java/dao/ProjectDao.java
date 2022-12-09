package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Project;
import util.HibernateUtil;

public class ProjectDao {

	private SessionFactory sessionFactory;

	public ProjectDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	
	public List<Project> getProjects() {
		List<Project> employees = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String query = "Select * from projects";
			employees = session.createNativeQuery(query, Project.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return employees;
	}

//	public boolean addEmployee(Employee employee) {
//		Session session = sessionFactory.getCurrentSession();
//		Transaction tr = session.getTransaction();
//		try {
//			tr.begin();
//			session.persist(employee);
//			tr.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tr.rollback();
//		}
//
//		return false;
//	}
//
//	public Employee getEmployee(String id) {
//		Employee emp = null;
//		Session session = sessionFactory.getCurrentSession();
//		Transaction tr = session.getTransaction();
//		try {
//			tr.begin();
//			emp = session.find(Employee.class, id);
//			tr.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tr.rollback();
//		}
//
//		return emp;
//	}



}
