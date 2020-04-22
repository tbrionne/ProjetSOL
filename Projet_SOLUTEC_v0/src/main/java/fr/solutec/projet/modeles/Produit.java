package fr.solutec.projet.modeles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Produit")
public class Produit {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "PRODUIT_ID", nullable=false)
	private Integer idProduit;
	@Column(name = "PRODUIT_NAME", nullable=false)
	private String name;
	@Column(name = "CATEGORIE_ID", nullable=false)
	private Integer idCategorie;
	@Column(name = "MARQUE", nullable=false)
	private String marque;
	@Column(name = "PRIX", nullable=false)
	private Integer prix;
	@Column(name = "PHOTO", nullable=false)
	private String photo;
	//@ManyToOne
	@Column(name = "CLASSE_ENERGETIQUE_ID", nullable=false)
	private String classeEnergetique;
	
	//Getters and setters
	
	public Integer getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}
	public String getClasseEnergetique() {
		return classeEnergetique;
	}
	public void setClasseEnergetique(String classeEnergetique) {
		this.classeEnergetique = classeEnergetique;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
}
