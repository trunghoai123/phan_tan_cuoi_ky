package app;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dao.AssignmentDao;
import dao.EmployeeDao;
import dao.ProjectDao;
import entity.Employee;

public class App {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		ProjectDao projectDao = (ProjectDao) Naming.lookup("rmi://DESKTOP-3RSB9S0:9090/projectDao");
		EmployeeDao employeeDao = (EmployeeDao) Naming.lookup("rmi://DESKTOP-3RSB9S0:9090/employeeDao");
		AssignmentDao assignmentDao = (AssignmentDao) Naming.lookup("rmi://DESKTOP-3RSB9S0:9090/assignmentDao");
		
		projectDao.getProjects().forEach((prj) -> {
			System.out.println(prj);
		});
		employeeDao.getEmployees().forEach((emp) -> {
			System.out.println(emp);
		});
		assignmentDao.getAssignments().forEach((asm) -> {
			System.out.println(asm);
		});
		
	}
}
