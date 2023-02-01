package com.flightResrvation.ControllerLayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightResrvation.Dto.ReservationUpdateRequest;
import com.flightResrvation.Entity.Reservation;
import com.flightResrvation.Repository.ReservationRepository;

@RestController
public class ReservationRestController {
	@Autowired
	private ReservationRepository reservationRepo;

	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable ("id") long id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}
	@RequestMapping("/reservation")
	public Reservation UpdateReservation(@RequestBody ReservationUpdateRequest dto) {
		Optional<Reservation> findById = reservationRepo.findById(dto.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(dto.isCheckedIn());
		reservation.setNumberOfBags(dto.getNumberOfBags());
		Reservation Reservation = reservationRepo.save(reservation);
		return reservation;
	}
}
