package entity;

import java.io.Serializable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="salaried_staffs")
@DiscriminatorValue("Salaried Staff")
public class SalariedStaff extends Staff implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2388354924476207384L;
	private double salary;
	
	public SalariedStaff() {
		
	}

	public SalariedStaff(long id, String name, String references, int age, double salary) {
		super(id, name, references, age);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "SalariedStaff [salary=" + salary + ", toString()=" + super.toString() + "]";
	}
}
