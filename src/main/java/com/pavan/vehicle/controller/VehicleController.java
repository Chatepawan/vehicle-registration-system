package com.pavan.vehicle.controller;

import com.pavan.vehicle.dto.VehicleRegistrationDto;
import com.pavan.vehicle.model.Vehicle;
import com.pavan.vehicle.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("vehicle", new Vehicle()); // Optional if form uses DTO
        return "register";
    }

    @PostMapping("/register")
    public String registerVehicle(@ModelAttribute VehicleRegistrationDto registrationDto,
                                  RedirectAttributes redirectAttributes) {
        Vehicle vehicle = vehicleService.registerVehicle(registrationDto);
        redirectAttributes.addAttribute("id", vehicle.getId());
        return "redirect:/vehicles/list";
    }

    @GetMapping("/list")
    public String listVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "list";
    }
}
