package com.pavan.vehicle.repository;

import com.pavan.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    boolean existsByVin(String vin);
    // Search by VIN (exact match)
    Optional<Vehicle> findByVin(String vin);

    // Search by make (contains, case insensitive)
    List<Vehicle> findByMakeContainingIgnoreCase(String make);

    // Search by registration number
    //@Query("SELECT v FROM Vehicle v JOIN v.registration r WHERE r.registrationNumber = :regNumber")
    //Optional<Vehicle> findByRegistrationNumber(@Param("regNumber") String regNumber);

    // Advanced search with multiple criteria
    @Query("SELECT v FROM Vehicle v WHERE " +
            "(:vin IS NULL OR v.vin LIKE %:vin%) AND " +
            "(:make IS NULL OR v.make LIKE %:make%) AND " +
            "(:model IS NULL OR v.model LIKE %:model%) AND " +
            "(:color IS NULL OR v.color LIKE %:color%)")
    List<Vehicle> findByVinContainingOrMakeContainingOrModelContainingOrColorContaining(
            @Param("vin") String vin,
            @Param("make") String make,
            @Param("model") String model,
            @Param("color") String color);
}
