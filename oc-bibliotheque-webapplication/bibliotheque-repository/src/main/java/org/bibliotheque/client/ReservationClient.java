package org.bibliotheque.client;


import org.bibliotheque.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;

public class ReservationClient extends WebServiceGatewaySupport {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(ReservationClient.class);

    /**
     *
     * @param ouvrage_id
     * @return
     */
    public GetListReservationByOuvrageIdResponse getListReservationByOuvrageId (Integer ouvrage_id){

        GetListReservationByOuvrageIdResponse response = new GetListReservationByOuvrageIdResponse();

        try{
            GetListReservationByOuvrageIdRequest request = new GetListReservationByOuvrageIdRequest();
            request.setOuvrageId(ouvrage_id);
            response = (GetListReservationByOuvrageIdResponse) getWebServiceTemplate().
                    marshalSendAndReceive(request);

        } catch (SoapFaultClientException pEX) {
            logger.error("GetListReservationByOuvrageIdResponse : {}", pEX.getMessage());
        }

        return response;
    }


    /**
     *
     * @param compteId
     * @return
     */
    public GetListReservationByCompteIdResponse getListReservationByCompteId (Integer compteId) {

        GetListReservationByCompteIdResponse response = new GetListReservationByCompteIdResponse();

        try {
            GetListReservationByCompteIdRequest request = new GetListReservationByCompteIdRequest();
            request.setCompteId(compteId);
            response = (GetListReservationByCompteIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        } catch (SoapFaultClientException pEX) {
            logger.error("GetListReservationByCompteIdResponse : {}", pEX.getMessage());
        }

        return response;
    }

}
