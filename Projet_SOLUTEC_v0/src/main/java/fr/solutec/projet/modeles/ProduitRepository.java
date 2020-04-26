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

	@Query("SELECT DISTINCT produit_id FROM Produit  ")
    Integer[] selectProduitId();
    
    @Query("SELECT DISTINCT p.prix FROM Produit p where p.produit_id=?1")
    Integer  selectPrixParId(int nId);
    @Query("SELECT DISTINCT p.produit_name FROM Produit p where p.produit_id=?1 ")
    String selectNomParId(int nId);
    @Query("SELECT DISTINCT p.photo FROM Produit p where p.produit_id=?1 ")
    String selectPhotoParId(int nId);
	
	
	
	// Tri

	// Tri produits par ID
	@Query("SELECT p FROM Produit p ORDER BY p.produit_id asc")
	Collection<Produit> selectProduitParIdAsc();

	@Query("SELECT p FROM Produit p ORDER BY p.produit_id desc")
	Collection<Produit> selectProduitParIdDesc();

	// Tri produits par NOM
	@Query("SELECT p FROM Produit p ORDER BY p.produit_name asc")
	Collection<Produit> selectProduitParNomAsc();

	@Query("SELECT p FROM Produit p ORDER BY p.produit_name desc")
	Collection<Produit> selectProduitParNomDesc();

	// Tri produits par CATEGORIE
	@Query("SELECT p FROM Produit p ORDER BY p.categorie_id asc")
	Collection<Produit> selectProduitParCategorieAsc();

	@Query("SELECT p FROM Produit p ORDER BY p.categorie_id desc")
	Collection<Produit> selectProduitParCategorieDesc();

	// Tri produits par Marque
	@Query("SELECT p FROM Produit p ORDER BY p.marque asc")
	Collection<Produit> selectProduitParMarqueAsc();

	@Query("SELECT p FROM Produit p ORDER BY p.marque desc")
	Collection<Produit> selectProduitParMarqueDesc();

	// Tri produits par PRIX
	@Query("SELECT p FROM Produit p ORDER BY p.prix asc")
	Collection<Produit> selectProduitParPrixAsc();

	@Query("SELECT p FROM Produit p ORDER BY p.prix desc")
	Collection<Produit> selectProduitParPrixDesc();

	// Tri produits par CLASSE ENERGETIQUE
	@Query("SELECT p FROM Produit p ORDER BY p.classe_energetique_id asc")
	Collection<Produit> selectProduitParClasseEnergetiqueAsc();

	@Query("SELECT p FROM Produit p ORDER BY p.classe_energetique_id desc")
	Collection<Produit> selectProduitParClasseEnergetiqueDesc();

	// Tri produits par PHOTO
	@Query("SELECT p FROM Produit p ORDER BY p.photo asc")
	Collection<Produit> selectProduitParPhotoAsc();

	@Query("SELECT p FROM Produit p ORDER BY p.photo desc")
	Collection<Produit> selectProduitParPhotoDesc();

	
	
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

	// Filtrer les produits par la borne de prix supérieure
	@Query("SELECT p FROM Produit p where p.prix >?1")
	Collection<Produit> selectPrixMax(Integer n);

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

	// Filtrer par marques, classe énergétique et prix en borne supérieure
	@Query("SELECT p FROM Produit p WHERE p.marque = ?1 AND p.classe_energetique_id = ?2 AND p.prix >?3")
	Collection<Produit> selectParFiltresMax(String s, Integer n1, Integer n2);
	// Filtres simples + Catégorie

	// Filtrer les produits par marques
	@Query("SELECT p FROM Produit p WHERE p.categorie_id =?1 AND p.marque = ?2")
	Collection<Produit> selectParMarqueEtCatégorie(Integer n, String s);

	// Filtrer les produits par classe énergétiques
	@Query("SELECT p FROM Produit p WHERE p.categorie_id =?1 AND p.classe_energetique_id = ?2")
	Collection<Produit> selectParClassesEtCatégorie(Integer n1, Integer n2);

	// Filtrer les produits par prix
	@Query("SELECT p FROM Produit p where p.categorie_id =?1 AND p.prix <=?2")
	Collection<Produit> selectPrixEtCatégorie(Integer n1, Integer n2);

	// Filtrer les produits par la borne de prix supérieure
	@Query("SELECT p FROM Produit p where p.categorie_id =?1 AND p.prix >?2")
	Collection<Produit> selectPrixMaxEtCatégorie(Integer n1, Integer n2);

	// Filtres doubles + Catégorie

	// Filtrer par marques et classe énergétique
	@Query("SELECT p FROM Produit p WHERE p.categorie_id =?1 AND  p.marque = ?2 AND p.classe_energetique_id = ?3")
	Collection<Produit> selectParMarqueEtClasseEtCatégorie(Integer n1, String s, Integer n2);

	// Filtrer par marques et prix
	@Query("SELECT p FROM Produit p WHERE p.categorie_id =?1 AND p.marque = ?2 AND p.prix <= ?3")
	Collection<Produit> selectParMarqueEtPrixEtCatégorie(Integer n1, String s, Integer n2);

	// Filtrer par classe énergétique et prix
	@Query("SELECT p FROM Produit p WHERE p.categorie_id =?1 AND p.classe_energetique_id = ?2 AND p.prix <= ?3")
	Collection<Produit> selectParClasseEtPrixEtCatégorie(Integer n1, Integer n2, Integer n3);

	// Filtre triple + Catégorie

	// Filtrer par marques, classe énergétique et prix
	@Query("SELECT p FROM Produit p WHERE p.categorie_id =?1 AND p.marque = ?2 AND p.classe_energetique_id = ?3 AND p.prix <=?4")
	Collection<Produit> selectParFiltresEtCatégorie(Integer n1, String s, Integer n2, Integer n3);

	// Filtrer par marques, classe énergétique et prix en borne supérieure
	@Query("SELECT p FROM Produit p WHERE p.categorie_id =?1 AND p.marque = ?2 AND p.classe_energetique_id = ?3 AND p.prix >?4")
	Collection<Produit> selectParFiltresMaxEtCatégorie(Integer n1, String s, Integer n2, Integer n3);
}
