package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.registration.entity.Registration;
@Repository
public interface RegistrationRepository  extends JpaRepository<Registration,Integer>{

	Registration findByFirstName(String name);

}
