package org.bibliotheque.repository;

import org.bibliotheque.client.ReservationClient;
import org.bibliotheque.wsdl.GetListReservationByOuvrageIdResponse;
import org.bibliotheque.wsdl.ReservationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepositoy {

    @Autowired
    private ReservationClient client;

    public List<ReservationType> reservationTypeListByOuvrageId (Integer ouvrageId) {
        GetListReservationByOuvrageIdResponse response = client.getListReservationByOuvrageId(ouvrageId);
        return response.getReservationListByOuvrageId();
    }
}
