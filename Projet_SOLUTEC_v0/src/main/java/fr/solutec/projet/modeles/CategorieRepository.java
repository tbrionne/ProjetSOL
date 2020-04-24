package fr.solutec.projet.modeles;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepository extends CrudRepository<Categorie, Integer> {

	@Query("SELECT p FROM Produit p where p.categorie_id =?1")
	Collection<Object> selectCategorie(Integer i);

	@Query("SELECT C.nomCategorie FROM Categorie C ") // , Produit p where p.categorie_id =C.idCategorie
	Collection<Object> selectCategorieName();



}
