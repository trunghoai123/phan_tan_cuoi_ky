package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "projects")
public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6345451481171456777L;
	@Id
	@Column(name = "prj_id", columnDefinition = "varchar(20)")	
	private String id;
	@Column(name="project_name", columnDefinition = "nvarchar(100)", unique = true, nullable = false)
	private String name;
	@Column(columnDefinition = "nvarchar(100)")
	private String location;
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	@Column(columnDefinition = "decimal(10,2)")
	private double budget;
	
	@OneToMany(mappedBy = "project")
	private List<Assignment> assignments;
	
	public Project() {
	}
	
	public Project(String id, String name, String location, Date startDate, double budget) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.startDate = startDate;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}


	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", location=" + location + ", startDate=" + startDate
				+ ", budget=" + budget + "]";
	}

}
