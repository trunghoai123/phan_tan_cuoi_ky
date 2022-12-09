package entity;

import java.io.Serializable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="hourly_staffs")
@DiscriminatorValue(value = "Hourly Staff")
public class HourlyStaff extends Staff implements Serializable{
	 
	private static final long serialVersionUID = -3823950765653711595L;
	private int hours;
	private double wage;
	
	public HourlyStaff() {

	}

	public HourlyStaff(long id, String name, String references, int age, int hours, double wage) {
		super(id, name, references, age);
		this.hours = hours;
		this.wage = wage;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	@Override
	public String toString() {
		return "HourlyStaff [hours=" + hours + ", wage=" + wage + ", toString()=" + super.toString() + "]";
	}
}
