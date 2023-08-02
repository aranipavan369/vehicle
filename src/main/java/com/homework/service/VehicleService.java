package com.homework.service;

import com.homework.model.vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    void createVehicle(vehicle vehicle);
    void createMultiplevehicles(List<vehicle> vehlist);
    vehicle updateVehicleDetails(vehicle vehicle);
    vehicle getVehicleById(Long id) throws Exception;
    String deleteVehicleById(Long id);
    List<vehicle> getVehicleListGreaterThan(int cost);
}
