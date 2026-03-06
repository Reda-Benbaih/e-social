package services;

import java.util.List;

import dao.EmployerDAO;
import model.Employer;

public class EmployerService {
	
	private EmployerDAO employerDAO = new EmployerDAO();
	
	public void addEmployer(String socialReason , String activity) {
		Employer employer = new Employer(socialReason , activity);
		employerDAO.save(employer);
	}
	
	public void updateEmployer(Employer employer) {
		employerDAO.update(employer);
	}
	
	public Employer getEmployer(int id) {
		return employerDAO.findById(id);
	}
	
	public List<Employer> getAllEmployers(){
		return employerDAO.findAll();
	}
	
	public void deleteEmployer(int id) {
		employerDAO.delete(id);
	}

}
