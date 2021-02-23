package fr.alexisGoupillot;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprunt")
public class Emprunt {
	
	@Id
	private int id;

	@Column(name = "DATE_DEBUT", nullable = false)
	private Date date_debut;
	
	@Column(name = "DATE_FIN", nullable = true)
	private Date date_fin;
	
	@Column(name = "DELAI", nullable = true)
	private int delai;

	@ManyToMany
	@JoinTable(name = "COMPO",
				joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"),
				inverseJoinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID")
	)
	private List<Livre> livres;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	
	@Override
	public String toString() {
		return id + " " + date_debut + " " + delai + livres;
	}
	
	public Emprunt() {}
}
