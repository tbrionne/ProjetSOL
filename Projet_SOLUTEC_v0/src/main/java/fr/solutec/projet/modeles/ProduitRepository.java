package fr.solutec.projet.modeles;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ProduitRepository extends CrudRepository<Produit, Integer>{
	
//	@Query("SELECT u FROM Utilisateur u ORDER BY u.nom")
//	Collection<Produit> selectUtilisateurParNom();
//	
//	@Query("SELECT u FROM Utilisateur u ORDER BY u.prenom")
//	Collection<Produit> selectUtilisateurParPrenom();
	
	@Query("SELECT DISTINCT p.marque FROM Produit p")
	Collection<String> selectMarque();
	
	@Query("SELECT DISTINCT p.classe_energetique_id FROM Produit p ORDER BY p.classe_energetique_id")
	Collection<String> selectClasseEnergetique();

}
