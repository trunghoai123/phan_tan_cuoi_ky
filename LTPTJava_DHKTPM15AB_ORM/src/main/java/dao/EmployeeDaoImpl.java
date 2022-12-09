package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Employee;
import util.HibernateUtil;

public class EmployeeDaoImpl extends UnicastRemoteObject implements EmployeeDao{

	private SessionFactory sessionFactory;

	public EmployeeDaoImpl() throws RemoteException{
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	
	@Override
	public boolean addEmployee(Employee employee) throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.persist(employee);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return false;
	}
	
	@Override
	public boolean removeEmployeeQuery(String id) throws RemoteException{ // phải thêm casecade vào association giữa emp và phones
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "DELETE FROM [dbo].[employees] WHERE emp_id = :id";
			session.createNativeQuery(query, Employee.class)
				.setParameter("id", id)
				.executeUpdate();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return false;
	}
	
	@Override
	public boolean updateEmployee(Employee employee) throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(employee);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return false;
	}
	
	@Override
	public Employee getEmployee(String id) throws RemoteException {
		Employee emp = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			emp = session.find(Employee.class, id);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return emp;
	}
	
	@Override
	public List<Employee> getEmployees() throws RemoteException {
		List<Employee> employees = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String query = "Select * from employees";
			employees = session.createNativeQuery(query, Employee.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return employees;
	}

}
