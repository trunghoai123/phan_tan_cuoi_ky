package entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "assignments")
@IdClass(AssignmentPK.class)	
public class Assignment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3072109633191174525L;

	@Id
	@ManyToOne
	@JoinColumn(name="emp_id", columnDefinition = "varchar(20)")
	private Employee employee;
	
	@Id
	@ManyToOne
	@JoinColumn(name="prj_id", columnDefinition = "varchar(20)")
	private Project project;
	
	private int hours;
	
	public Assignment() {
	}

	public Assignment(Employee employee, Project project, int hours) {
		super();
		this.employee = employee;
		this.project = project;
		this.hours = hours;
	}

	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "Assignment [employee=" + employee.getId() + ", project=" + project.getId() + ", hours=" + hours + "]";
	}

	
}
