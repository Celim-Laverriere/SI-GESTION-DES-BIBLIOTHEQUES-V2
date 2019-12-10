package org.bibliotheque.controller;

import org.bibliotheque.service.EmpruntService;
import org.bibliotheque.service.OuvrageService;
import org.bibliotheque.service.ReservationService;
import org.bibliotheque.wsdl.EmpruntType;
import org.bibliotheque.wsdl.LivreType;
import org.bibliotheque.wsdl.OuvrageType;
import org.bibliotheque.wsdl.ReservationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.ParseException;
import java.util.List;


@Controller
public class OuvrageController {

    private static final Logger logger = LoggerFactory.getLogger(OuvrageController.class);

    @Autowired
    private OuvrageService ouvrageService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private EmpruntService empruntService;


    @RequestMapping(value = "/ouvrages", method = RequestMethod.GET)
    public String ouvrages(final Model model){

        /**@see OuvrageService#ouvrageTypeList()*/
        List<OuvrageType> ouvrageTypeList = ouvrageService.ouvrageTypeList();

        /**@see OuvrageService#livresDispoForOuvrage(List)*/
        List<OuvrageType> ouvrageTypeListDisponible = ouvrageService.livresDispoForOuvrage(ouvrageService.ouvrageTypeList());

        model.addAttribute("ouvrageList", ouvrageTypeList);
        model.addAttribute("ouvrageListDisponible", ouvrageTypeListDisponible);

            return "ouvrage/ouvrageList";
    }


    @RequestMapping(value = "/ouvrage", method = RequestMethod.GET)
    public String ouvrageDetail(Model model, @RequestParam(name = "ouvrageId") Integer ouvrageId){

        try{

            /**@see OuvrageService#ouvrageById(Integer)*/
            OuvrageType ouvrageType = ouvrageService.ouvrageById(ouvrageId);

            /**@see OuvrageService#nombreDeLivreDispo(List)*/
            List<LivreType> livreTypeListDispo = ouvrageService.nombreDeLivreDispo(ouvrageType.getLivres());

            List<ReservationType> reservationTypeList = reservationService.reservationTypeListByOuvrageId(ouvrageId);

            List<EmpruntType> empruntTypeList = empruntService.getAllEmpruntByOuvrageId(ouvrageId);

            List<Long> jourRestantEmprunt = empruntService.remainingDayOfTheLoan(empruntTypeList);

            empruntTypeList = empruntService.earliestReturnDateForLoan(empruntTypeList, jourRestantEmprunt);

            model.addAttribute("livreTypeListDispo", livreTypeListDispo);
            model.addAttribute("ouvrageDetail", ouvrageType);
            model.addAttribute("reservationTypeList", reservationTypeList);
            model.addAttribute("dateRetour", empruntTypeList.get(0).getDateFin());
            model.addAttribute("compteurJour", jourRestantEmprunt.get(0));

          return "ouvrage/ouvrageDetail";

        } catch (NullPointerException | ParseException pEX){
            logger.error("/ouvrage : {}", pEX.toString());
           return "error";
        }
    }


    @RequestMapping(value = "/ouvragesByGenre", method = RequestMethod.GET)
    public String ouvragesByGenre(Model model, @RequestParam(name = "motCle") String motCle){

        /**@see OuvrageService#ouvragesByGenreList(String)*/
        List<OuvrageType> ouvrageTypeList = ouvrageService.ouvragesByGenreList(motCle);

        /**@see OuvrageService#livresDispoForOuvrage(List)*/
        List<OuvrageType> ouvrageTypeListDisponible = ouvrageService.livresDispoForOuvrage(ouvrageService.ouvragesByGenreList(motCle));

        model.addAttribute("ouvrageList", ouvrageTypeList);
        model.addAttribute("ouvrageListDisponible", ouvrageTypeListDisponible);

        return "ouvrage/ouvrageList";
    }

}
