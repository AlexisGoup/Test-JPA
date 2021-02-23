package fr.alexisGoupillot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpa {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		//Ville v = em.find(Ville.class, 6);
		//System.out.println(v);
	}

}
