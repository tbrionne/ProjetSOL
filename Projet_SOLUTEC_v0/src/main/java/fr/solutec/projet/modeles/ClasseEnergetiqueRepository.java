package fr.solutec.projet.modeles;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ClasseEnergetiqueRepository extends CrudRepository<ClasseEnergetique, Integer>{
	
	@Query("SELECT C.nomClasseEnergetique FROM ClasseEnergetique C ")
	Collection<Object> selectClasseEnergetiqueName();

}
