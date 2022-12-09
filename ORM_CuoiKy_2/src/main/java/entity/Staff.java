package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="staffs")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "disc")
public abstract class Staff implements Serializable{
	
	private static final long serialVersionUID = -8512618400253541413L;
	@Id 
	@Column(name="staff_id")
	protected long id;
	@Column(name="staff_name", nullable = false, columnDefinition = "nvarchar(100)")
	protected String name;
	@Column(name = "refers")
	protected String references;
	protected int age;
	
	@PrimaryKeyJoinColumn
	@OneToOne(mappedBy = "staff")
	protected Profile profile;
	
//	@ManyToMany(mappedBy = "staffs")
//	protected Set<Project> projects;  
	
	@OneToMany(mappedBy = "staff")
	protected List<StaffOfProject>  staffOfProjects;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	protected Department dept;
	
	@ElementCollection
	@JoinTable(name="phones", joinColumns = @JoinColumn(name="staff_id"))
	@Column(name="number", nullable = false)
	protected Set<String> phoneNumbers;
	
	public Staff() {
		
	}
	
	public Staff(long id, String name, String references, int age) {
		super();
		this.id = id;
		this.name = name;
		this.references = references;
		this.age = age;
	}

	public List<StaffOfProject> getStaffOfProjects() {
		return staffOfProjects;
	}

	public void setStaffOfProjects(List<StaffOfProject> staffOfProjects) {
		this.staffOfProjects = staffOfProjects;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReferences() {
		return references;
	}

	public void setReferences(String references) {
		this.references = references;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
 
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", references=" + references + ", age=" + age + ", profile="
				+ profile + ", projects=" + "" + ", dept=" + dept + ", phoneNumbers=" + phoneNumbers + "]";
	}
}
