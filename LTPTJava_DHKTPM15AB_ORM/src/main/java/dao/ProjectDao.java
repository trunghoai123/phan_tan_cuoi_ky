package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Project;

public interface ProjectDao extends Remote{

	public boolean addProject(Project project) throws RemoteException;

	public Project getProject(String prjId) throws RemoteException;

	public List<Project> getProjects() throws RemoteException;

}
