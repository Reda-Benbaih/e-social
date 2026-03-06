package services;

import java.math.BigDecimal;

import dao.EmployeeDAO;
import model.Employee;
import model.Employer;

public class EmployeeService {
	
	EmployeeDAO employeeDAO = new EmployeeDAO();
	
	public void addEmployee(String name, BigDecimal monthlySalary, Employer employer) {
			Employee employee = new Employee(name,monthlySalary,employer);
	}

}
