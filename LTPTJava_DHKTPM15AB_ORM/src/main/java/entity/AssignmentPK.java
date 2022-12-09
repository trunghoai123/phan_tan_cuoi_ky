package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class AssignmentPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5382649643110528859L;
	private String employee;
	private String project;

	public AssignmentPK() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(employee, project);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignmentPK other = (AssignmentPK) obj;
		return Objects.equals(employee, other.employee) && Objects.equals(project, other.project);
	}
	
	
}
