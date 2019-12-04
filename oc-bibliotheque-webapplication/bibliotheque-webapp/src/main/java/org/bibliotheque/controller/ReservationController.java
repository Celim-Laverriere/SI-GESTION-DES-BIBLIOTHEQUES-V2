package org.bibliotheque.controller;

import org.bibliotheque.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


}
