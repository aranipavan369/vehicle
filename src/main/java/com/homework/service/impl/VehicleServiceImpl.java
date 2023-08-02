package com.homework.service.impl;

import com.homework.model.vehicle;
import com.homework.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {
    public List<vehicle> list=new ArrayList<>();
    @Override
    public void createVehicle(vehicle vehicle) {
        list.add(vehicle);
    }

    @Override
    public void createMultiplevehicles(List<vehicle> vehlist) {
        list.addAll(vehlist);
    }

    @Override
    public vehicle updateVehicleDetails(vehicle vehicle) {
        list.forEach(i->{
            if(i.getId().equals(vehicle.getId())){
                i.setId(vehicle.getId());
                i.setName(vehicle.getName());
                i.setCost(vehicle.getCost());
            }
        });
        return list.stream().filter(i->i.getId().equals(vehicle.getId())).findFirst().orElse(null);
    }

    @Override
    public vehicle getVehicleById(Long id) throws Exception {
        return list.stream().filter(i->i.getId().equals(id)).findFirst().orElseThrow(()->new Exception("invalid credentials could not find vehicle with id as"+id));
    }

    @Override
    public String deleteVehicleById(Long id) {
        list=list.stream().filter(i->!i.getId().equals(id)).toList();
        return "Vehicle is under damage and not available";
    }

    @Override
    public List<vehicle> getVehicleListGreaterThan(int cost) {
        return list.stream().filter(i->i.getCost()>cost).toList();
    }
}
