//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.12.03 à 02:14:41 PM CET 
//


package org.bibliotheque.wsdl;

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
 *         &lt;element name="photoType" type="{http://www.webservice.org/bibliotheque-ws}photoType"/&gt;
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
    "photoType"
})
@XmlRootElement(name = "addPhotoRequest")
public class AddPhotoRequest {

    @XmlElement(required = true)
    protected PhotoType photoType;

    /**
     * Obtient la valeur de la propriété photoType.
     * 
     * @return
     *     possible object is
     *     {@link PhotoType }
     *     
     */
    public PhotoType getPhotoType() {
        return photoType;
    }

    /**
     * Définit la valeur de la propriété photoType.
     * 
     * @param value
     *     allowed object is
     *     {@link PhotoType }
     *     
     */
    public void setPhotoType(PhotoType value) {
        this.photoType = value;
    }

}
