package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="employees")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 669660195493327369L;
	@Id
	@Column(name="emp_id", columnDefinition = "varchar(20)")
	private String id;
	@Column(nullable = false, name="full_name", columnDefinition = "nvarchar(100)")
	private String name;
	@Column(nullable = false, unique = true, columnDefinition = "varchar(100)")
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name="hire_date")
	private Date hireDate;
	
	@ElementCollection
	@JoinTable(name="phones",joinColumns = @JoinColumn(name="emp_id"))
	@Column(name = "phone", nullable = false, columnDefinition = "varchar(100)")
	
	private Set<String> phones;

	@OneToMany(mappedBy = "employee")
	private List<Assignment> assignments;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee manager;
	
	public Employee() {
	}

	public Employee(String id, String name, String email, Date hireDate, Set<String> phones) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.hireDate = hireDate;
		this.phones = phones;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", hireDate=" + hireDate  + ", manager=" + (manager == null? "": manager.getId()) + "]";
	}

	

}
