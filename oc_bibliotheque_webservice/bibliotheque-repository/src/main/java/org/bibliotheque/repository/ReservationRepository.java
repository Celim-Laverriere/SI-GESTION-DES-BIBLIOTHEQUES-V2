package org.bibliotheque.repository;

import org.bibliotheque.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Integer> {

    Iterable<Object> findAllById(Integer ouvrageId);

}
