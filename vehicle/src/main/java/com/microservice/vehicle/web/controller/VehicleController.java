package com.microservice.vehicle.web.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.microservice.vehicle.dao.IVehicleDAO;
import com.microservice.vehicle.model.Vehicle;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    //@Autowired

    private IVehicleDAO vehicleDAO;

    @GetMapping
    public Object listAllVehicle(){
       Iterable<Vehicle> vehicles = vehicleDAO.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue vehiclesFiltres = new MappingJacksonValue(vehicles);

        vehiclesFiltres.setFilters(listDeNosFiltres);

        return vehiclesFiltres;
    }
//    @GetMapping
//    public String printTest(){
//        return "hello test";
//    }




}
