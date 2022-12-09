package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.AssignmentDao;
import dao.AssignmentDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import dao.ProjectDao;
import dao.ProjectDaoImpl;
import entity.Employee; 

public class Server {
	public static void main(String[] args) throws NamingException, RemoteException {
			
		Hashtable<String, String> env  = new Hashtable<String, String>();
		env.put("java.security.policy", "rmi/policy.policy");
		Context context = new InitialContext(env);
		LocateRegistry.createRegistry(9090);

		EmployeeDao employeeDao = new EmployeeDaoImpl();
		ProjectDao projectDao = new ProjectDaoImpl();
		AssignmentDao assignmentDao = new AssignmentDaoImpl();
		
//		Employee emp = new Employee("EMP2", "John Tran 2 ","john.tran@gmail.com", new Date(2010 - 1900, 12, 1),
//				new HashSet<String>(Arrays.asList("09 789-789", "09 345-890")));
//		employeeDao.updateEmployee(emp);
		
		context.bind("rmi://DESKTOP-3RSB9S0:9090/employeeDao", employeeDao);
		context.bind("rmi://DESKTOP-3RSB9S0:9090/projectDao", projectDao);
		context.bind("rmi://DESKTOP-3RSB9S0:9090/assignmentDao", assignmentDao);
			
		System.out.println("Ready...");
		
	}
}
