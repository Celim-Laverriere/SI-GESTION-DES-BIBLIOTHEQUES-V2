package org.bibliotheque.service;

import org.bibliotheque.repository.ReservationRepositoy;
import org.bibliotheque.wsdl.ReservationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepositoy repositoy;

    public List<ReservationType> reservationTypeListByOuvrageId(Integer ouvrageId){
        return repositoy.reservationTypeListByOuvrageId(ouvrageId);
    }
}
