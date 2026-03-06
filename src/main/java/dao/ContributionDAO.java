package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Contribution;
import util.JPAUtil;

public class ContributionDAO {
	
	public void save(Contribution contribution) {
		EntityManager em = JPAUtil.GetEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(contribution);
		tx.commit();
		
		em.close();		
	}
	
	public Contribution findById(int id) {
		EntityManager em = JPAUtil.GetEntityManager();
		Contribution contribution = em.find(Contribution.class, id);
		em.close();
		return contribution;
	}
	
	public void update(Contribution contribution) {
	    EntityManager em = JPAUtil.GetEntityManager();
	    EntityTransaction tx = em.getTransaction();

	    tx.begin();
	    em.merge(contribution);
	    tx.commit();

	    em.close();
	}
	
	public List<Contribution> findAll(){
		EntityManager em = JPAUtil.GetEntityManager();
		List<Contribution> list = em.createQuery("FROM Contribution",Contribution.class).getResultList();
		em.close();
		return list;
	}
	
	public void delete(int id) {
		EntityManager em = JPAUtil.GetEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Contribution contribution = em.find(Contribution.class, id);
		
		if (contribution != null) {
			em.remove(contribution);
		}
		tx.commit();
		em.close();
		
	}
}
