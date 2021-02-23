package fr.alexisGoupillot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestJpa {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// TP 2
		Ville v = em.find(Ville.class, 6);
		System.out.println(v);
		
		
		// TP3
		Livre l = em.find(Livre.class, 1);
		System.out.println(l);
		
		Emprunt e = em.find(Emprunt.class, 1);
		System.out.println(e + "\n");
		
		TypedQuery<Emprunt> queryEmprunts = em.createQuery("SELECT e FROM Emprunt e WHERE e.client.id = 1", Emprunt.class);
		List<Emprunt> listEmprunts = queryEmprunts.getResultList();

		for(Emprunt emprunt : listEmprunts) {
			System.out.println(emprunt + "\n");
		}
	}

}
