package com.flightResrvation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.flightResrvation.Dto.ReservationRequest;
import com.flightResrvation.Entity.Flight;
import com.flightResrvation.Entity.Passenger;
import com.flightResrvation.Entity.Reservation;
import com.flightResrvation.Repository.FlightRepository;
import com.flightResrvation.Repository.PassengerRepository;
import com.flightResrvation.Repository.ReservationRepository;
import com.flightResrvation.utility.EmailUtil;
import com.flightResrvation.utility.PDFGenerator;
@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private PassengerRepository Passengerrepo;
	@Autowired
	private FlightRepository flightRepo;
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private PDFGenerator pdfGenerator;

	@Autowired
	private EmailUtil emailutil;
	@Override
	public Reservation bookFlight(ReservationRequest dto) {
		Passenger passenger =new Passenger();
		passenger.setFirstName(dto.getFirstName());
		passenger.setLastName(dto.getLastName());
		passenger.setMiddleName(dto.getMiddleName());
		passenger.setEmail(dto.getEmail());
		passenger.setPhone(dto.getPhone());
		Passengerrepo.save(passenger);
		
		long flightId = dto.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation =new Reservation();
		reservation.setPassenger(passenger);
		reservation.setFlight(flight);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		String filepath="C:\\stscode\\flight_Reservation_app1\\tickets\\reservation"+reservation.getId()+".pdf";
		 reservationRepo.save(reservation);
	
		
		pdfGenerator.generateItinerary(reservation,filepath);
		emailutil.sendItinerary(passenger.getEmail(),filepath);
		return reservation;
	}

}
