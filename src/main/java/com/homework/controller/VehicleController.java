package com.homework.controller;

import com.homework.model.vehicle;
import com.homework.service.VehicleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService service;

    @PostMapping("/addVehicle")
    public String addVehicle(@RequestBody vehicle vehicle)
    {
        service.createVehicle(vehicle);
        return "Vehicle is added";
    }

    @PostMapping("/addMulVehicle")
    public String addMulVehicle(@RequestBody List<vehicle> list)
    {
        service.createMultiplevehicles(list);
        return "Vehicles are added";
    }

    @RequestMapping(value = "/searchvehicle/{id}",method = RequestMethod.GET)
    public vehicle searchEmployee(@PathVariable Long id) throws Exception {
        return service.getVehicleById(id);
    }
    @PutMapping("/updatevehicle")
    public vehicle updtevehicle(@RequestBody vehicle vehicle)
    {

        return service.updateVehicleDetails(vehicle);
    }
    @RequestMapping(value = "/deletevehicle/{id}",method = RequestMethod.GET)
    public String DeleteEmployee(@PathVariable Long id) throws Exception {
        return service.deleteVehicleById(id);
    }

    @GetMapping("/GetvehGrtrThan")
    public List<vehicle> getvehicles(@RequestParam int cost)
    {
        return service.getVehicleListGreaterThan(cost);
    }


}
