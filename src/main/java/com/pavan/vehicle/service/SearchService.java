package com.pavan.vehicle.service;

import com.pavan.vehicle.model.Vehicle;
import com.pavan.vehicle.model.VehicleSearchCriteria;
import com.pavan.vehicle.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final VehicleRepository vehicleRepository;

    public SearchService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> simpleSearch(String query) {
        return vehicleRepository.findByMakeContainingIgnoreCase(query);
    }

    public List<Vehicle> advancedSearch(VehicleSearchCriteria criteria) {
        return vehicleRepository.findByVinContainingOrMakeContainingOrModelContainingOrColorContaining(
                criteria.getVin() != null ? criteria.getVin() : "",
                criteria.getMake() != null ? criteria.getMake() : "",
                criteria.getModel() != null ? criteria.getModel() : "",
                criteria.getColor() != null ? criteria.getColor() : ""
        );
    }
}
