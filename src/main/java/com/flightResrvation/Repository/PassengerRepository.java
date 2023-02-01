package com.flightResrvation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightResrvation.Entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {

}
