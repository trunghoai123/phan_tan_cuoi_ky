package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Employee;

public interface EmployeeDao extends Remote{

	boolean addEmployee(Employee employee) throws RemoteException;

	Employee getEmployee(String id) throws RemoteException;

	List<Employee> getEmployees() throws RemoteException;

	boolean updateEmployee(Employee employee) throws RemoteException;
 

	boolean removeEmployeeQuery(String id) throws RemoteException;
	
}
