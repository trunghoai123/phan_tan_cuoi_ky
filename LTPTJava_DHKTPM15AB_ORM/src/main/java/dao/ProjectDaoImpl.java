package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Project;
import util.HibernateUtil;

public class ProjectDaoImpl extends UnicastRemoteObject implements ProjectDao{

	private SessionFactory sessionFactory;

	public ProjectDaoImpl() throws RemoteException{
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	@Override
	public boolean addProject(Project project) throws RemoteException{

		if(!(project.getStartDate().after(new Date()) && project.getBudget() > 0))
			return false;

		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.persist(project);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return false;
	}
	@Override
	public Project getProject(String prjId) throws RemoteException{
		Project project = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			project = session.find(Project.class, prjId);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return project;
	}
	@Override
	public List<Project> getProjects() throws RemoteException {
		List<Project> projects = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String query = "select * from projects";
			projects = session.createNativeQuery(query, Project.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return projects;
	}

}
