package fr.solutec.projet.modeles;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CategorieRepository extends CrudRepository<Categorie, Integer>{
	
	@Query("SELECT p.prix FROM Produit p where p.categorie_id =2")
	Integer selectCategorieParId();
//	@Query("SELECT u FROM Utilisateur u ORDER BY u.nom")
//	Collection<Produit> selectUtilisateurParNom();
//	
//	@Query("SELECT u FROM Utilisateur u ORDER BY u.prenom")
//	Collection<Produit> selectUtilisateurParPrenom();

}
