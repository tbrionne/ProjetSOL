package fr.solutec.projet.modeles;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ClasseEnergetiqueRepository extends CrudRepository<ClasseEnergetique, Integer>{
	
//	@Query("SELECT DISTINCT ce.classe_energetique_name FROM ClasseEnergetique ce ORDER BY ce.classe_energetique_name")
//	Collection<String> selectClasseEnergetique();

}
