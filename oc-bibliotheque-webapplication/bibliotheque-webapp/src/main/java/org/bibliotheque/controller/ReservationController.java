package org.bibliotheque.controller;

import org.bibliotheque.service.EmpruntService;
import org.bibliotheque.service.OuvrageService;
import org.bibliotheque.service.ReservationService;
import org.bibliotheque.wsdl.EmpruntType;
import org.bibliotheque.wsdl.OuvrageType;
import org.bibliotheque.wsdl.ReservationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private OuvrageService ouvrageService;

    @Autowired
    private EmpruntService empruntService;

    @GetMapping (value = "/reservation")
    public String reservation( Model model, @RequestParam(name = "ouvrageId") Integer ouvrageId){

        OuvrageType ouvrageType = ouvrageService.ouvrageById(ouvrageId);

        List<ReservationType> reservationTypeList = reservationService.reservationTypeListByOuvrageId(ouvrageId);

        model.addAttribute("ouvrage", ouvrageType);
        model.addAttribute("reservationList", reservationTypeList);

        return "reservation/reservation";
    }
}
