package com.pavan.vehicle.service;

import com.pavan.vehicle.model.Customer;
import com.pavan.vehicle.model.Registration;
import com.pavan.vehicle.model.Vehicle;
import com.pavan.vehicle.repository.CustomerRepository;
import com.pavan.vehicle.repository.RegistrationRepository;
import com.pavan.vehicle.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// src/main/java/com/pavan/vehicle/service/RegistrationService.java
@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;

    public Registration findById(Long id) {
        return registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id: " + id));
    }

    public List<Registration> findByCustomerId(Long customerId) {
        return registrationRepository.findByCustomerId(customerId);
    }

    @Transactional
    public Registration createRegistration(Long vehicleId, Long customerId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Registration registration = new Registration();
        registration.setVehicle(vehicle);
        registration.setCustomer(customer);
        registration.setRegistrationNumber(generateRegNumber());
        registration.setIssueDate(LocalDate.now());
        registration.setExpiryDate(LocalDate.now().plusYears(1));
        registration.setStatus("APPROVED");
        registration.setFee(new BigDecimal("500.00"));

        return registrationRepository.save(registration);
    }

    private String generateRegNumber() {
        return "REG-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}