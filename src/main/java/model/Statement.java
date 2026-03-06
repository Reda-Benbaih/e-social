package model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table (name = "statement")
public class Statement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn (name = "employerId")
	private Employer employer;
	private int month;
	private int year;
	private LocalDate statementDate;
	
	public Statement() {}
	
	public Statement(Employer employer, int month, int year, LocalDate statementDate) {
		super();
		this.employer = employer;
		this.month = month;
		this.year = year;
		this.statementDate = statementDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public LocalDate getStatementDate() {
		return statementDate;
	}

	public void setStatementDate(LocalDate statementDate) {
		this.statementDate = statementDate;
	}

	@Override
	public String toString() {
		return "Statement [id=" + id + ", employer=" + employer + ", month=" + month + ", year=" + year
				+ ", statementDate=" + statementDate + "]";
	}		
}
