package model;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table (name = "contribution")
public class Contribution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "statementId")
	private Statement statement;
	private BigDecimal employeeContribution;
	private BigDecimal employerContribution;
	
	public Contribution() {}
	
	public Contribution(Employee employee, Statement statement, BigDecimal employeeContribution,
			BigDecimal employerContribution) {
		super();
		this.employee = employee;
		this.statement = statement;
		this.employeeContribution = employeeContribution;
		this.employerContribution = employerContribution;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	
	public BigDecimal getEmployeeContribution() {
		return employeeContribution;
	}
	public void setEmployeeContribution(BigDecimal employeeContribution) {
		this.employeeContribution = employeeContribution;
	}
	public BigDecimal getEmployerContribution() {
		return employerContribution;
	}
	public void setEmployerContribution(BigDecimal employerContribution) {
		this.employerContribution = employerContribution;
	}
	@Override
	public String toString() {
		return "contribution [id=" + id + ", employee=" + employee + ", statement=" + statement
				+ ", employeeContribution=" + employeeContribution + ", employerContribution=" + employerContribution
				+ "]";
	}
	
	
	
	
}
