package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Employer;
import util.JPAUtil;

public class EmployerDAO {
	public void save(Employer employer) {
		
		EntityManager em = JPAUtil.GetEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(employer);
		tx.commit();
		
		em.close();
	}
	
	public Employer findById(int id) {
		EntityManager em = JPAUtil.GetEntityManager();
		Employer employer = em.find(Employer.class, id);
		em.close();
		return employer;
	}
	
	public void update(Employer employer) {
	    EntityManager em = JPAUtil.GetEntityManager();
	    EntityTransaction tx = em.getTransaction();

	    tx.begin();
	    em.merge(employer);
	    tx.commit();

	    em.close();
	}
	
	public List<Employer> findAll(){
		EntityManager em = JPAUtil.GetEntityManager();
		List<Employer> list = em.createQuery("FROM Employer",Employer.class).getResultList();
		em.close();
		return list;
	}
	
	public void delete(int id) {
		EntityManager em = JPAUtil.GetEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Employer employer = em.find(Employer.class, id);
		
		if(employer != null) {
			em.remove(employer);
		}
		tx.commit();
		em.close();
	}
}
