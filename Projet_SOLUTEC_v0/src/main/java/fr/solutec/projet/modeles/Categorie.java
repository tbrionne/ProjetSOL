package fr.solutec.projet.modeles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CATEGORIE_ID", nullable=false)
	private Integer idCategorie;
	@Column(name = "CATEGORIE_NAME", nullable=false)
	private String nomCategorie;
	
	//Getters and setters
	public Integer getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getName() {
		return nomCategorie;
	}
	public void setName(String name) {
		this.nomCategorie = name;
	}
	
	
	
	
}
