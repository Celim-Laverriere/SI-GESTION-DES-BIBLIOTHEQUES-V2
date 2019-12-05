package org.bibliotheque.repository;

import org.bibliotheque.entity.EmpruntEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmpruntRepository extends CrudRepository<EmpruntEntity, Integer> {

   List<EmpruntEntity> findAllByCompteId(Integer compte_id);


   @Query("SELECT DISTINCT emprunt FROM public.emprunt " +
           "INNER JOIN livre ON emprunt.livre_id = livre.id " +
           "WHERE emprunt.livre_id = livre.id " +
           "AND livre.ouvrage_id = 1")
   List<EmpruntEntity> findAllEmpruntByOuvrageId(@Param("x") Integer ouvrage_id);
}
