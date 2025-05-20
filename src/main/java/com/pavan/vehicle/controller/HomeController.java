// src/main/java/com/pavan/vehicle/controller/HomeController.java
package com.pavan.vehicle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; 
    }
}