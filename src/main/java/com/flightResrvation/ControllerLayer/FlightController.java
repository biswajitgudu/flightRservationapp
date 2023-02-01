package com.flightResrvation.ControllerLayer;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightResrvation.Entity.Flight;
import com.flightResrvation.Repository.FlightRepository;

@Controller
public class FlightController {
	@Autowired
	private FlightRepository flightRepo;

	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam ("from") String from,@RequestParam("to") String to,@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy")Date departureDate,Model model) 
	{
		List<Flight> flights = flightRepo.findFlights(from,to,departureDate);
		model.addAttribute("findflights", flights);
		System.out.println(flights);
		return "displayFlights  ";
		
	}
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam ("flightId") long flightId,Model model) {
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		model.addAttribute("flight", flight);
		return "showCompleteReservation";
	}
}
