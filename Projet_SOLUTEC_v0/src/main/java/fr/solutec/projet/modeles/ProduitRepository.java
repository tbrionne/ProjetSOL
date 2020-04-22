package fr.solutec.projet.modeles;

//import java.util.Collection;
//
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ProduitRepository extends CrudRepository<Produit, Integer>{
	
//	@Query("SELECT u FROM Utilisateur u ORDER BY u.nom")
//	Collection<Produit> selectUtilisateurParNom();
//	
//	@Query("SELECT u FROM Utilisateur u ORDER BY u.prenom")
//	Collection<Produit> selectUtilisateurParPrenom();

}
