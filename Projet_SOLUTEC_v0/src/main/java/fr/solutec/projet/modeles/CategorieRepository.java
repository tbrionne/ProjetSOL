package fr.solutec.projet.modeles;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CategorieRepository extends CrudRepository<Categorie, Integer>{
	
	@Query("SELECT p FROM Produit p where p.categorie_id =1")
	Collection<Object> selectCategorie1();
	@Query("SELECT p FROM Produit p where p.categorie_id =2")
	Collection<Object> selectCategorie2();
	@Query("SELECT p FROM Produit p where p.categorie_id =3")
	Collection<Object> selectCategorie3();
	@Query("SELECT p FROM Produit p where p.categorie_id =4")
	Collection<Object> selectCategorie4();

}
