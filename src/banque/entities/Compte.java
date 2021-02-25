package banque.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private String numero;
	private double solde;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="compte_client",
				joinColumns=@JoinColumn(name = "id_compte", referencedColumnName = "ID"),
				inverseJoinColumns=@JoinColumn(name="id_client", referencedColumnName = "ID")
				)
	private List<Client> client = new ArrayList<Client>();
	
	@OneToMany(mappedBy="compte")
	private List<Operation> operations = new ArrayList<Operation>();
	
	public Compte() {};
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
}