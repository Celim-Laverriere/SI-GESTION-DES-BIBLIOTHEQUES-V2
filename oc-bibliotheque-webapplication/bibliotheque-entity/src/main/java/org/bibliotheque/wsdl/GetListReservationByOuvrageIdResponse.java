//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.12.03 à 02:14:41 PM CET 
//


package org.bibliotheque.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reservationListByOuvrageId" type="{http://www.webservice.org/bibliotheque-ws}reservationType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "reservationListByOuvrageId"
})
@XmlRootElement(name = "getListReservationByOuvrageIdResponse")
public class GetListReservationByOuvrageIdResponse {

    @XmlElement(required = true)
    protected List<ReservationType> reservationListByOuvrageId;

    /**
     * Gets the value of the reservationListByOuvrageId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reservationListByOuvrageId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReservationListByOuvrageId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReservationType }
     * 
     * 
     */
    public List<ReservationType> getReservationListByOuvrageId() {
        if (reservationListByOuvrageId == null) {
            reservationListByOuvrageId = new ArrayList<ReservationType>();
        }
        return this.reservationListByOuvrageId;
    }

}
