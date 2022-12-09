package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="projects")
@NamedQueries({
	@NamedQuery(name = "get-all-products", query = "select p from Project p")
})
public class Project implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2792651660782969544L;
	@Id
	@Column(name="project_id")
	private String id;
	@Column(name="project_name")
	private String name;
	private double budget;
	
//	@ManyToMany
//	@JoinTable(name = "staff_projects", joinColumns = @JoinColumn(name= "project_id", referencedColumnName = "project_id"),
//				inverseJoinColumns = @JoinColumn(name="staff_id", referencedColumnName = "staff_id")
//			)
//	private Set<Staff> staffs;

	@OneToMany(mappedBy = "project")
	private List<StaffOfProject>  staffOfProjects; 
	
	public Project() {
	}

	public List<StaffOfProject> getStaffOfProjects() {
		return staffOfProjects;
	}

	public void setStaffOfProjects(List<StaffOfProject> staffOfProjects) {
		this.staffOfProjects = staffOfProjects;
	}

	public Project(String id, String name, double budget, Set<Staff> staffs) {
		super();
		this.id = id;
		this.name = name;
		this.budget = budget;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}


	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", budget=" + budget +  "]";
	}
}
