package fr.solutec.projet.modeles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Produit")
public class Produit {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "PRODUIT_ID", nullable=false)
	private Integer produit_id;
	@Column(name = "PRODUIT_NAME", nullable=false)
	private String produit_name;
	@Column(name = "CATEGORIE_ID")
	private Integer categorie_id;
	@Column(name = "MARQUE", nullable=false)
	private String marque;
	@Column(name = "PRIX", nullable=false)
	private Integer prix;
	@Column(name = "PHOTO", nullable=false)
	private String photo;
	@Column(name="CLASSE_ENERGETIQUE_ID")
	private Integer classe_energetique_id;
	
	//Getters and setters
	public Integer getProduit_id() {
		return produit_id;
	}
	public void setProduit_id(Integer produit_id) {
		this.produit_id = produit_id;
	}
	public String getProduit_name() {
		return produit_name;
	}
	public void setProduit_name(String produit_name) {
		this.produit_name = produit_name;
	}
	public Integer getCategorie_id() {
		return categorie_id;
	}
	public void setCategorie_id(Integer categorie_id) {
		this.categorie_id = categorie_id;
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
	public Integer getClasse_energetique_id() {
		return classe_energetique_id;
	}
	public void setClasse_energetique_id(Integer classe_energetique_id) {
		this.classe_energetique_id = classe_energetique_id;
	}
	
	
	
	
	
	
	
	
}
