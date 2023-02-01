package com.flightResrvation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightResrvation.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String emailId);

}
