package com.flightResrvation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightResrvation.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}
