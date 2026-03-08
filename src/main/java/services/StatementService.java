package services;

import java.time.LocalDate;
import java.util.List;

import dao.StatementDAO;
import model.Employer;
import model.Statement;

public class StatementService {
	
	StatementDAO statementDAO = new StatementDAO();
	
	public void addStatement(Employer employer, int month, int year, LocalDate statementDate) {

	    List<Statement> statements = statementDAO.findAll();

	    for (Statement s : statements) {
	        if (s.getEmployer().getId() == employer.getId()
	            && s.getMonth() == month
	            && s.getYear() == year) {

	            throw new RuntimeException("Statement already exists for this employer/month/year");
	        }
	    }

	    Statement statement = new Statement(employer, month, year, statementDate);
	    statementDAO.save(statement);
	}
	
	public void updateStatement(Statement statement) {
		statementDAO.update(statement);
	}
	
	public Statement getStatement(int id) {
		return statementDAO.findById(id);
	}
	
	public List<Statement> getAllStatement(){
		return statementDAO.findAll();
	}
	
	public void deleteStatement(int id) {
		statementDAO.remove(id);
	}
}
