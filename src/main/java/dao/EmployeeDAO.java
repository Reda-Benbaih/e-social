package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Employee;
import util.JPAUtil;

public class EmployeeDAO {
	public void save(Employee employee) {
		EntityManager em = JPAUtil.GetEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(employee);
		tx.commit();
		
		em.close();
	}
	
	public Employee findById(int id) {
		EntityManager em = JPAUtil.GetEntityManager();
		Employee employee = em.find(Employee.class, id);
		em.close();
		return employee;
	}
	
	public void update(Employee employee) {
	    EntityManager em = JPAUtil.GetEntityManager();
	    EntityTransaction tx = em.getTransaction();

	    tx.begin();
	    em.merge(employee);
	    tx.commit();

	    em.close();
	}
	
	public List<Employee> findAll(){
		EntityManager em = JPAUtil.GetEntityManager();
		List<Employee> list = em.createQuery("FROM Employee",Employee.class).getResultList();
		em.close();
		return list;
	}
	
	public void delete(int id) {
		EntityManager em =JPAUtil.GetEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Employee employee = em.find(Employee.class, id);
		
		if(employee != null) {
			em.remove(employee);
		}
		tx.commit();
		em.close();
		
	}
}
