package services;

import java.math.BigDecimal;
import java.util.List;

import dao.EmployeeDAO;
import model.Employee;
import model.Employer;

public class EmployeeService {
	
	EmployeeDAO employeeDAO = new EmployeeDAO();
	
	public void addEmployee(String name, BigDecimal monthlySalary, Employer employer) {
			Employee employee = new Employee(name,monthlySalary,employer);
			employeeDAO.save(employee);
	}
	
	public void updateEmployee(Employee employee) {
		employeeDAO.update(employee);
	}
	
	public Employee getEmployee(int id) {
		return employeeDAO.findById(id);
	}
	public List<Employee> getAllEmployee(){
		return employeeDAO.findAll();
	}
	
	public void deleteEmployee(int id) {
		employeeDAO.delete(id);
	}

}
