package com.pavan.vehicle.repository;

import com.pavan.vehicle.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

// src/main/java/com/pavan/vehicle/repository/RegistrationRepository.java
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByCustomerId(Long customerId);
    Optional<Registration> findByRegistrationNumber(String regNumber);
    Optional<Registration> findById(Long id);
}
