package com.flightResrvation.ControllerLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flightResrvation.Dto.ReservationRequest;
import com.flightResrvation.Entity.Reservation;
import com.flightResrvation.service.ReservationService;


@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservation;


	@RequestMapping("/confirmationReservation")
	public String completeReservation(ReservationRequest dto,ModelMap model) {
		Reservation reservationId = reservation.bookFlight(dto);
		model.addAttribute("Reservation", reservationId.getId());
		return "confirmReservation";
	}
}
