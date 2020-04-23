package fr.solutec.projet.modeles;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepository extends CrudRepository<Categorie, Integer> {

	@Query("SELECT p FROM Produit p where p.categorie_id =?1")
	Collection<Object> selectCategorie(Integer i);

	@Query("SELECT C.nomCategorie FROM Categorie C ") // , Produit p where p.categorie_id =C.idCategorie
	Collection<Object> selectCategorieName();

///// pour les filtres
	@Query("SELECT p FROM Produit p where p.prix <=100")
	Collection<Object> selectPrix1();

	@Query("SELECT p FROM Produit p where p.prix between 100 and 500")
	Collection<Object> selectPrix2();

	@Query("SELECT p FROM Produit p where p.prix between 500 and 1000")
	Collection<Object> selectPrix3();

}
