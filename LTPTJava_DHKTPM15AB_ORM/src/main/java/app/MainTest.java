 package app;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import dao.AssignmentDao;
import dao.AssignmentDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import dao.ProjectDaoImpl;
import entity.Assignment;
import entity.Employee;
import entity.Project;

public class MainTest {
	public static void main(String[] args) throws RemoteException {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		ProjectDaoImpl projectDao = new ProjectDaoImpl();
		AssignmentDao assignmentDao = new AssignmentDaoImpl(); 
		
//		Employee emp1 = new Employee("EMP1", "John Smith", "john.smith@gmail.com", new Date(2000 - 1900, 12, 1), 
//				new HashSet<String>(Arrays.asList("09 456-789", "09 345-567")));
//		Employee emp2 = new Employee("EMP2", "John Tran","john.tran@gmail.com", new Date(2010 - 1900, 12, 1), 
//				new HashSet<String>(Arrays.asList("09 789-789", "09 345-890","34 456-764")));

		
		Employee emp3 = new Employee("EMP11", "John Smith", "hoaih@ma2il.com", new Date(2000 - 1900, 8, 20), 
				new HashSet<String>(Arrays.asList("09 456-789", "09 345-567")));
		
		Employee emp4 = employeeDao.getEmployee("EMP9");
//		employeeDao.addEmployee(emp3 );
		employeeDao.removeEmployeeQuery(emp4.getId());
//		emp2.setManager(emp1);
//		employeeDao.addEmployee(emp1 );
//		employeeDao.addEmployee(emp2 );
//		
//		Project prj1 = new Project("PRJ01", "Database System", "UAS", new Date(2022 - 1900, 12, 5) , 987.45);
//		Project prj2 = new Project("PRJ02", "Laser Printers", "UAS", new Date(2022 - 1900, 12, 5) , 387.50);
		
//		Project prj2 = new Project("PRJ05", "Laser Printers", "UAS", new Date(2022 - 1900, 12, 5) , 387.50);
//		
//		projectDao.addProject(prj2);
//		
//		System.out.println(projectDao.addProject(prj1));
//		
//		Assignment assignment1 = new Assignment(emp1, prj1, 15);
//		Assignment assignment2 = new Assignment(emp1, prj2, 25);
//		Assignment assignment3 = new Assignment(emp2, prj1, 35);
//		
//		assignmentDao.addAssignment(assignment1);
//		assignmentDao.addAssignment(assignment2);
//		assignmentDao.addAssignment(assignment3); 
		
		
//		List<Employee> employees = employeeDao.getEmployees();
//		employees.forEach(emp -> System.out.println(emp));
//		
//		assignmentDao.getAssignments().forEach((asm) -> {
//			System.out.println(asm);
//		});
//		
//		Project prj = projectDao.getProject("PRJ05");
//		Employee emp = employeeDao.getEmployee("EMP10");
//		Assignment asm = new Assignment(emp, prj, 1000);
//		System.out.println(assignmentDao.addAssignmentQuery(asm));
		
		
	}
}
