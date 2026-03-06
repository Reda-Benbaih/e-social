package model;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private BigDecimal monthlySalary;
	
	@ManyToOne
	@JoinColumn(name = "employerId")
	private Employer employer;
	
	public Employee() {}
	
	public Employee(String name, BigDecimal monthlySalary, Employer employer) {
		this.name = name;
		this.monthlySalary = monthlySalary;
		this.employer = employer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(BigDecimal monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", monthlySalary=" + monthlySalary + ", employer=" + employer
				+ "]";
	}	
}
