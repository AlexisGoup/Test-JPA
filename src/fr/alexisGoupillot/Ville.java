package fr.alexisGoupillot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "villes")
public class Ville {
	String nomCommune;
	Integer population;
	@Id
	Integer id;
	
	public String getNomCommune() {
		return nomCommune;
	}
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Ville() {}
	
	@Override
	public String toString() {
		return nomCommune + " " + population + " " + id;
	}
	
}
