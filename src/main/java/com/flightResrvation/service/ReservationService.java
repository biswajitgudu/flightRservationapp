package com.flightResrvation.service;

import com.flightResrvation.Dto.ReservationRequest;
import com.flightResrvation.Entity.Reservation;

public interface ReservationService {
Reservation bookFlight(ReservationRequest dto);
}
