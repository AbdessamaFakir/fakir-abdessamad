package org.annuaire.dao;

import java.util.Optional;

import org.annuaire.entities.Personne;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
	
public Personne findPersonneByNom(String nom);
@Query("select c from Personne c where c.bureau like :x")
public Personne findByBureau(@Param("x")String mc);
	
}
