package fr.solutec.projet.modeles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClasseEnergetique")
public class ClasseEnergetique {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CLASSE_ENERGETIQUE_ID", nullable=false)
	//@OneToMany
	private Integer idClasseEnergetique;
	@Column(name = "CLASSE_ENERGETIQUE_NAME", nullable=false)
	private String nomClasseEnergetique;
	
	//Getters and setters
	
	public Integer getIdClasseEnergetique() {
		return idClasseEnergetique;
	}
	public void setIdClasseEnergetique(Integer idClasseEnergetique) {
		this.idClasseEnergetique = idClasseEnergetique;
	}
	public String getNomClasseEnergetique() {
		return nomClasseEnergetique;
	}
	public void setNomClasseEnergetique(String nomClasseEnergetique) {
		this.nomClasseEnergetique = nomClasseEnergetique;
	}
	
}
