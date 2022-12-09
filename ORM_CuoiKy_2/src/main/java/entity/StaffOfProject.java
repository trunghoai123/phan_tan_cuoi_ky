package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "staff_projects")
@IdClass(StaffOfProjectPK.class)
public class StaffOfProject implements Serializable{
	@Id
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	@Id
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;
	
	public StaffOfProject(Project project, Staff staff) {
		super();
		this.project = project;
		this.staff = staff;
	}
	public StaffOfProject() {
		super();
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}	
}
