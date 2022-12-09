package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Assignment;

public interface AssignmentDao extends Remote{

	boolean addAssignment(Assignment assignment) throws RemoteException;

	boolean addAssignmentQuery(Assignment assignment) throws RemoteException;

	Assignment getAssignment(String empId, String prjId) throws RemoteException;

	List<Assignment> getAssignments() throws RemoteException;

}
