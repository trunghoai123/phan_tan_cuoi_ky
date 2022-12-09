package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Assignment;
import util.HibernateUtil;

public class AssignmentDaoImpl extends UnicastRemoteObject implements AssignmentDao{

	private SessionFactory sessionFactory;

	public AssignmentDaoImpl() throws RemoteException{
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	@Override
	public boolean addAssignment(Assignment assignment) throws RemoteException{
		boolean rs = false;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.merge(assignment);
			tr.commit();
			rs = true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return rs;
	}
	@Override
	public boolean addAssignmentQuery(Assignment assignment) throws RemoteException{
		boolean rs = false;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String sql = "INSERT INTO [dbo].[assignments] ([emp_id], [prj_id], [hours]) VALUES (:emp_id, :prj_id, :hours)";
			session.createNativeQuery(sql, Assignment.class)
					.setParameter("emp_id", assignment.getEmployee().getId())
					.setParameter("prj_id", assignment.getProject().getId())
					.setParameter("hours", assignment.getHours())
					.executeUpdate();
			tr.commit();
			rs = true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return rs;
	}

	@Override
	public Assignment getAssignment(String empId, String prjId) throws RemoteException{
		Assignment ass = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String sql = "select * from [dbo].[assignments] where [emp_id] = :x and [prj_id] = :y";
			List<Assignment> temp = session.createNativeQuery(sql, Assignment.class)
					.setParameter("x", empId)
					.setParameter("y", prjId)
					.getResultList();
			tr.commit();
			ass = temp.size() > 0 ? temp.get(0) : null;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return ass;
	}
	@Override
	public List<Assignment> getAssignments() throws RemoteException{
		List<Assignment> assignments = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "Select * from assignments";
			assignments = session.createNativeQuery(query, Assignment.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return assignments;
	}

}
