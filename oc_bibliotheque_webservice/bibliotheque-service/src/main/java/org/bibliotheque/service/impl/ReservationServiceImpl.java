package org.bibliotheque.service.impl;

import org.bibliotheque.entity.ReservationEntity;
import org.bibliotheque.repository.ReservationRepository;
import org.bibliotheque.service.contract.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public ReservationEntity getReservationById(Integer id) {
        return this.reservationRepository.findById(id).get();
    }

    @Override
    public List<ReservationEntity> getAllReservations() {
        List<ReservationEntity> reservationEntityList = new ArrayList<>();
        this.reservationRepository.findAll().forEach(e -> reservationEntityList.add(e));
        return reservationEntityList;
    }

    @Override
    public List<ReservationEntity> getListReservationByOuvrageId(Integer ouvrageId) {
        List<ReservationEntity> reservationEntityListByOuvrageId = new ArrayList<>();
        this.reservationRepository.findAllById(ouvrageId).forEach(e -> reservationEntityListByOuvrageId.add((ReservationEntity) e));
        return reservationEntityListByOuvrageId;
    }
}
