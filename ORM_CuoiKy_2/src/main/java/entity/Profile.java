package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="profiles")
public class Profile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2999410335277824799L;
	@Id
	private long id;
	private String avatar;
	@Column(columnDefinition = "text")
	private String description;
	
	@MapsId
	@OneToOne
	@JoinColumn(name="staff_id")
	private Staff staff;

	
	public Profile() {
	} 

	public Profile(long id, String avatar, String description) {
		super();
		this.id = id;
		this.avatar = avatar;
		this.description = description;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Staff getStaff() {
		return staff;
	}


	public void setStaff(Staff staff) {
		this.staff = staff;
	}


	@Override
	public String toString() {
		return "Profile [id=" + id + ", avatar=" + avatar + ", description=" + description + "]";
	}
}
