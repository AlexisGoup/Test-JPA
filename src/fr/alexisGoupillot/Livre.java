package fr.alexisGoupillot;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Livre {
	@Id
	private int id;
	
	@Column(name = "TITRE", nullable = false)
	private String titre;
	
	@Column(name = "AUTEUR", nullable = false)
	private String auteur;
	
	@ManyToMany
	@JoinTable(name = "COMPO",
			joinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID")
			)
	private List<Emprunt> emprunts;

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Livre() {};
	public String toString() {
		return "Livre => " + id + " " + titre + " " + auteur;
	}
}
