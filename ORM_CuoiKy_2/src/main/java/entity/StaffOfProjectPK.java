package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class StaffOfProjectPK implements Serializable{
	private String project;
	private long staff;
	
	public StaffOfProjectPK() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(project, staff);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StaffOfProjectPK other = (StaffOfProjectPK) obj;
		return Objects.equals(project, other.project) && staff == other.staff;
	}
	
}
