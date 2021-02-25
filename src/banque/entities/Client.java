package banque.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	
	private String prenom;
	
	private LocalDate dateNaissance;
	
	@Embedded
	private Adresse adresse;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_banque")
	private Banque banque;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="compte_client",
				joinColumns=@JoinColumn(name = "id_client", referencedColumnName = "ID"),
				inverseJoinColumns=@JoinColumn(name="id_compte", referencedColumnName = "ID")
				)
	private List<Compte> comptes = new ArrayList<Compte>();
	
	public Client() {};
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
}
