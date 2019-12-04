package org.bibliotheque.service.contract;

import org.bibliotheque.entity.ReservationEntity;

import java.util.List;

public interface ReservationService {

    ReservationEntity getReservationById(Integer id);

    List<ReservationEntity> getAllReservations();

    List<ReservationEntity> getListReservationByOuvrageId( Integer ouvrageId);
}
