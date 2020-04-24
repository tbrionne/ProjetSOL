package fr.solutec.projet.modeles;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProduitRepository extends CrudRepository<Produit, Integer> {

	// Récupération listes
	
	// Récupérer toutes les marques
	@Query("SELECT DISTINCT p.marque FROM Produit p")
	Collection<String> selectMarque();
	// Récupérer toutes les classes énergétiques
	@Query("SELECT DISTINCT p.classe_energetique_id FROM Produit p ORDER BY p.classe_energetique_id")
	Collection<String> selectClasseEnergetique();
	
	// Tri
	
	// Tri produits par ID descendant
	@Query("SELECT p FROM Produit p ORDER BY p.produit_id asc")
	Collection<Produit> selectProduitParIdAsc();
	
	@Query("SELECT p FROM Produit p ORDER BY p.produit_id desc")
	Collection<Produit> selectProduitParIdDesc();
	
	@Query("SELECT p FROM Produit p ORDER BY p.produit_name asc")
	Collection<Produit> selectProduitParNomAsc();

	@Query("SELECT p FROM Produit p ORDER BY p.produit_name desc")
	Collection<Produit> selectProduitParNomDesc();


	// Filtres simples
	
	// Filtrer les produits par marques
	@Query("SELECT p FROM Produit p WHERE p.marque = ?1")
	Collection<Produit> selectParMarque(String s);
	// Filtrer les produits par classe énergétiques
	@Query("SELECT p FROM Produit p WHERE p.classe_energetique_id = ?1")
	Collection<Produit> selectParClasses(Integer n);
	// Filtrer les produits par prix
	@Query("SELECT p FROM Produit p where p.prix <=?1")
	Collection<Produit> selectPrix(Integer n);
	
	// Filtres doubles
	
	// Filtrer par marques et classe énergétique
	@Query("SELECT p FROM Produit p WHERE p.marque = ?1 AND p.classe_energetique_id = ?2")
	Collection<Produit> selectParMarqueEtClasse(String s, Integer n);
	// Filtrer par marques et prix
	@Query("SELECT p FROM Produit p WHERE p.marque = ?1 AND p.prix <= ?2")
	Collection<Produit> selectParMarqueEtPrix(String s, Integer n);
	// Filtrer par classe énergétique et prix
	@Query("SELECT p FROM Produit p WHERE p.classe_energetique_id = ?1 AND p.prix <= ?2")
	Collection<Produit> selectParClasseEtPrix(Integer n1, Integer n2);
	
	// Filtre triple
	
	// Filtrer par marques, classe énergétique et prix
	@Query("SELECT p FROM Produit p WHERE p.marque = ?1 AND p.classe_energetique_id = ?2 AND p.prix <=?3")
	Collection<Produit> selectParFiltres(String s, Integer n1, Integer n2);

}
