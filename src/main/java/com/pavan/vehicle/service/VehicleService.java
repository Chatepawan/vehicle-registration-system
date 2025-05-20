package com.pavan.vehicle.service;

import com.pavan.vehicle.dto.VehicleRegistrationDto;
import com.pavan.vehicle.model.Customer;
import com.pavan.vehicle.model.Vehicle;
import com.pavan.vehicle.repository.CustomerRepository;
import com.pavan.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;
    @Autowired
    private final RegistrationService registrationService;

    public VehicleService(VehicleRepository vehicleRepository,
                          CustomerRepository customerRepository,
                          RegistrationService registrationService) {
        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
        this.registrationService = registrationService;
    }


    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // src/main/java/com/pavan/vehicle/service/VehicleService.java
    @Transactional
    public Vehicle registerVehicle(VehicleRegistrationDto dto) {
        // 1. Handle Customer
        Customer owner = customerRepository.findByEmail(dto.getOwnerEmail())
                .orElseGet(() -> {
                    Customer newCustomer = new Customer();
                    newCustomer.setName(dto.getOwnerName());
                    newCustomer.setAddress(dto.getOwnerAddress());
                    newCustomer.setEmail(dto.getOwnerEmail());
                    newCustomer.setPhone(dto.getOwnerPhone());
                    return customerRepository.save(newCustomer);
                });

        // 2. Create and save Vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(dto.getVin());
        vehicle.setMake(dto.getMake());
        vehicle.setModel(dto.getModel());
        vehicle.setYear(dto.getYear());
        vehicle.setColor(dto.getColor());
        vehicle.setOwner(owner);

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        // 3. Automatically create registration
        registrationService.createRegistration(savedVehicle.getId(), owner.getId());

        return savedVehicle;
    }
}
