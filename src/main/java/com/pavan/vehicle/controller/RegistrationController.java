package com.pavan.vehicle.controller;

import com.pavan.vehicle.model.Registration;
import com.pavan.vehicle.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// src/main/java/com/pavan/vehicle/controller/RegistrationController.java
@Controller
@RequestMapping("/registrations")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @GetMapping("/{id}")
    public String getRegistration(@PathVariable Long id, Model model) {
        Registration registration = registrationService.findById(id);
        model.addAttribute("registration", registration);
        return "registration/summary";
    }

    @GetMapping("/customer/{customerId}")
    public String getCustomerRegistrations(@PathVariable Long customerId, Model model) {
        List<Registration> registrations = registrationService.findByCustomerId(customerId);
        model.addAttribute("registrations", registrations);
        return "registration/customer-list";
    }
}
