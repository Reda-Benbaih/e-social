package services;
import java.math.BigDecimal;

import dao.ContributionDAO;
import model.Contribution;
import model.Employee;
import model.Statement;

public class ContributionService {
	private static final BigDecimal EMPLOYEE_PERCENT = new BigDecimal("0.05");
	private static final BigDecimal EMPLOYER_PERCENT = new BigDecimal("0.10");
	
	private ContributionDAO contributionDAO = new ContributionDAO();
	
	public Contribution createContribution(Employee employee,Statement statement ) {
		BigDecimal salary = employee.getMonthlySalary();
		
		BigDecimal employeeContribution = salary.multiply(EMPLOYEE_PERCENT);
		BigDecimal employerContribution = salary.multiply(EMPLOYER_PERCENT);
		
		Contribution contribution = new Contribution(
				employee,
				statement,
				employeeContribution,
				employerContribution
				);
		contributionDAO.save(contribution);
		
		return contribution;
	}
}
