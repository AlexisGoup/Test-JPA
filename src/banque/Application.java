package banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.entities.Adresse;
import banque.entities.Banque;
import banque.entities.Client;
import banque.entities.Compte;
import banque.entities.Operation;

public class Application {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();			
		
		// DEBUT DE LA TRANSACTION 
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(instAll());
		transaction.commit();
	}
	
	private static Client instAll() {
		// BNP 
				Banque bnp = new Banque();
				bnp.setNom("BNP Paribas");
				
				// CLIENT 1
				Client client1 = new Client();
				LocalDate birthdayClient1 = LocalDate.now();
				Adresse adresseClient1 = new Adresse();
				Compte compte_1DuClient1 = new Compte();
				Compte compte_2DuClient1 = new Compte();
				Operation virementDebase = new Operation();
				Operation virementDebase2 = new Operation();
				
				// CONSTRUCTION ADRESSE CLIENT 1
				adresseClient1.setCodePostal(34000);
				adresseClient1.setNumero(6);
				adresseClient1.setRue("Rue du Puech");
				adresseClient1.setVille("Montpellier");
				
				// CONSTRUCTION DE DEUX COMPTES POUR CLIENT 1
				compte_1DuClient1.setNumero("55");
				compte_1DuClient1.setSolde(1000000);		
				compte_2DuClient1.setNumero("56");
				compte_2DuClient1.setSolde(5000);
				
				// AJOUT SUR CLIENT 1 DE DEUX COMPTES 
				List<Compte> listeComptes_Client1 = client1.getComptes();
				listeComptes_Client1.add(compte_1DuClient1);
				listeComptes_Client1.add(compte_2DuClient1);
				
				// CREATION DE DEUX VIREMENTS
				virementDebase.setCompte(compte_1DuClient1);
				virementDebase.setDate(LocalDateTime.now());
				virementDebase.setMontant(4500);
				virementDebase.setMotif("Anniversaire");		
				virementDebase2.setCompte(compte_1DuClient1);
				virementDebase2.setDate(LocalDateTime.now());
				virementDebase2.setMontant(4500);
				virementDebase2.setMotif("Anniversaire le retour");
				
				// AJOUT DES VIREMENTS SUR CLIENT 1
				List<Operation> listeOperations_Client1 = compte_1DuClient1.getOperations();
				listeOperations_Client1.add(virementDebase);
				listeOperations_Client1.add(virementDebase2);
				
				// CONSTRUCTION DES ATTRIBUTS DE CLIENT 1
				client1.setNom("Bouiffe");
				client1.setPrenom("Rachel");
				client1.setDateNaissance(birthdayClient1);
				client1.setAdresse(adresseClient1);
				client1.setComptes(listeComptes_Client1);
				client1.setBanque(bnp);
				
				return client1;
	}

}
