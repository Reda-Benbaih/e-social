package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class JPAUtil {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("brief") ;
	
	public static EntityManager GetEntityManager() {
		return emf.createEntityManager();
	}
}
