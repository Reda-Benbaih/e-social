package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Statement;
import util.JPAUtil;

public class StatementDAO {
	public void save(Statement statement) {
		EntityManager em = JPAUtil.GetEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(statement);
		tx.commit();
		
		em.close();
	}
	
	public Statement findById(int id) {
		EntityManager em = JPAUtil.GetEntityManager();
		Statement statement = em.find(Statement.class, id);
		em.close();
		return statement;
	}
	
	public void update(Statement statement) {
	    EntityManager em = JPAUtil.GetEntityManager();
	    EntityTransaction tx = em.getTransaction();

	    tx.begin();
	    em.merge(statement);
	    tx.commit();

	    em.close();
	}
	
	public List<Statement> findAll(){
		EntityManager em = JPAUtil.GetEntityManager();
		List<Statement> list = em.createQuery("FROM Statement",Statement.class).getResultList();
		em.close();
		return list;
	}
	
	public void remove(int id) {
		EntityManager em = JPAUtil.GetEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Statement statement = em.find(Statement.class, id);
		
		if(statement != null) {
			em.remove(statement);
		}
		
		tx.commit();
		em.close();
		
	}
}
