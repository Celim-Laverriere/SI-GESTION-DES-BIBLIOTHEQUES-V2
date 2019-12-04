package org.bibliotheque.endpoint;

import com.bibliotheque.gs_ws.*;
import lombok.NoArgsConstructor;
import org.bibliotheque.entity.ReservationEntity;
import org.bibliotheque.service.contract.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Endpoint
@NoArgsConstructor
public class ReservationEndpoint {

    public static final String NAMESPACE_URI = "http://www.webservice.org/bibliotheque-ws";

    @Autowired
    private ReservationService service;


    /**
     *
     * @param request
     * @return
     * @throws DatatypeConfigurationException
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllResrvationRequest")
    @ResponsePayload
    public GetAllReservationResponse getAllReservation(
            @RequestPayload GetAllReservationRequest request) throws DatatypeConfigurationException {

        GetAllReservationResponse response = new GetAllReservationResponse();
        List<ReservationEntity> reservationEntityList = service.getAllReservations();
        List<ReservationType> reservationTypeList = new ArrayList<>();

        for (ReservationEntity entity : reservationEntityList) {
            ReservationType reservationType = new ReservationType();
            GregorianCalendar calendar = new GregorianCalendar();

            calendar.setTime(entity.getDateDemandeDeResa());
            XMLGregorianCalendar dateDemandeDeResa = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);

            reservationType.setId(entity.getId());
            reservationType.setDateDemandeDeResa(dateDemandeDeResa);
            reservationType.setOuvrageId(entity.getOuvrageId());
            reservationType.setNumPositionResa(entity.getNumPositionResa());
            reservationType.setCompteId(entity.getCompteId());

            reservationTypeList.add(reservationType);
        }

        response.getReservationList().addAll(reservationTypeList);
        return response;
    }


    /**
     *
     * @param request
     * @return
     * @throws DatatypeConfigurationException
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getListReservationByOuvrageIdRequest")
    @ResponsePayload
    public GetListReservationByOuvrageIdResponse getListReservationByOuvrageId(
            @RequestPayload GetListReservationByOuvrageIdRequest request) throws DatatypeConfigurationException {
        GetListReservationByOuvrageIdResponse response = new GetListReservationByOuvrageIdResponse();
        List<ReservationEntity> reservationEntityList = service.getListReservationByOuvrageId(request.getOuvrageId());
        List<ReservationType> reservationTypeList = new ArrayList<>();

        for (ReservationEntity entity : reservationEntityList) {
            ReservationType reservationType = new ReservationType();
            GregorianCalendar calendar = new GregorianCalendar();

            calendar.setTime(entity.getDateDemandeDeResa());
            XMLGregorianCalendar dateDemandeDeResa = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);

            reservationType.setId(entity.getId());
            reservationType.setDateDemandeDeResa(dateDemandeDeResa);
            reservationType.setOuvrageId(entity.getOuvrageId());
            reservationType.setNumPositionResa(entity.getNumPositionResa());
            reservationType.setCompteId(entity.getCompteId());

            reservationTypeList.add(reservationType);
        }

        response.getReservationListByOuvrageId().addAll(reservationTypeList);
        return response;
    }
}
