package banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.entities.Adresse;
import banque.entities.AssuranceVie;
import banque.entities.Banque;
import banque.entities.Client;
import banque.entities.Compte;
import banque.entities.LivretA;
import banque.entities.Operation;

public class Application {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();			
		
		// DEBUT DE LA TRANSACTION 
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(instAll());
		// FIN DE LA TRANSACTION
		transaction.commit();
	}
	
	private static Client instAll() {
				// BNP 
				Banque bnp = new Banque();
				bnp.setNom("BNP Paribas");
				
				// CLIENT 1
				Client client1 = new Client();
				
				// ANNIVERSAIRE DU CLIENT 1
				LocalDate birthdayClient1 = LocalDate.now();
				
				// CONSTRUCTION ADRESSE CLIENT 1
				Adresse adresseClient1 = new Adresse();
				adresseClient1.setCodePostal(34000);
				adresseClient1.setNumero(6);
				adresseClient1.setRue("Rue du Puech");
				adresseClient1.setVille("Montpellier");
				
				// CONSTRUCTION DE DEUX COMPTES POUR CLIENT 1
				Compte compte_1DuClient1 = new Compte();
				compte_1DuClient1.setNumero("55");
				compte_1DuClient1.setSolde(1000000);
				Compte compte_2DuClient1 = new Compte();
				compte_2DuClient1.setNumero("56");
				compte_2DuClient1.setSolde(5000);
				
				// CREATION DE DEUX VIREMENTS
				Operation virementDebase = new Operation();
				virementDebase.setCompte(compte_1DuClient1);
				virementDebase.setDate(LocalDateTime.now());
				virementDebase.setMontant(4500);
				virementDebase.setMotif("Anniversaire");
				Operation virementDebase2 = new Operation();
				virementDebase2.setCompte(compte_1DuClient1);
				virementDebase2.setDate(LocalDateTime.now());
				virementDebase2.setMontant(4500);
				virementDebase2.setMotif("Anniversaire le retour");
				
				// AJOUT DES VIREMENTS SUR CLIENT 1
				List<Operation> listeOperations_Client1 = compte_1DuClient1.getOperations();
				listeOperations_Client1.add(virementDebase);
				listeOperations_Client1.add(virementDebase2);
				
				// CREATION D'UN LIVRET A
				LivretA livretA_Client1 = new LivretA();
				livretA_Client1.setNumero("152");
				livretA_Client1.setSolde(1500);
				livretA_Client1.setTaux(1.5);
				
				// CREATION D'UNE ASSURANCE VIE
				AssuranceVie assVie_Client1 = new AssuranceVie();
				assVie_Client1.setDateFin(birthdayClient1);
				assVie_Client1.setNumero("153");
				assVie_Client1.setSolde(6500);
				assVie_Client1.setTaux(3.5);
				
				// AJOUT SUR CLIENT 1 DE DEUX COMPTES + LIVRET A + ASSURANCE VIE
				List<Compte> listeComptes_Client1 = client1.getComptes();
				listeComptes_Client1.add(compte_1DuClient1);
				listeComptes_Client1.add(compte_2DuClient1);
				listeComptes_Client1.add(livretA_Client1);
				listeComptes_Client1.add(assVie_Client1);
				
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
