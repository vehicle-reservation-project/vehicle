package com.microservice.vehicle.web.controller;

import com.microservice.vehicle.dao.IVehicleDAO;
import com.microservice.vehicle.exceptions.ExceptionAddVehicle;
import com.microservice.vehicle.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired

    private IVehicleDAO vehicleDAO;

    @GetMapping
    public List<Vehicle> listAllVehicles(@RequestParam(value = "type", required = false) String type){
        if (type == null){
          List<Vehicle> vehicles = vehicleDAO.findAll();
          return vehicles;
        } else {
            return vehicleDAO.findByType(type);
        }
    }

    @GetMapping("/maxhp/{maxHp}")
    public List<Vehicle> listAllVehiclesWithMaxHP(@PathVariable int maxHp){
            List<Vehicle> vehicles = vehicleDAO.findByFiscalHPowerIsLessThan(maxHp);
            return vehicles;
    }










    @GetMapping("/{id}")
    public Vehicle listOneVehicle(@PathVariable int id){
        return vehicleDAO.findById(id);
    }
    public void checkVehiclePut(Vehicle vehicle){
        if ((vehicle.getType()).equals("moto") && vehicle.getDisplacementMotorcycleCm3()==null){
            throw new ExceptionAddVehicle();
        }
        if ((vehicle.getType()).equals("comm") && vehicle.getLoadCapacityM3()==null){
            throw new ExceptionAddVehicle();
        }
        if ((vehicle.getType()).equals("car") && (vehicle.getLoadCapacityM3()!=null  || vehicle.getDisplacementMotorcycleCm3()!=null)){
            throw new ExceptionAddVehicle();
        }
    }

    @PostMapping
    public Vehicle addNewVehicle(@RequestBody Vehicle vehicle) throws ExceptionAddVehicle{
        checkVehiclePut(vehicle);
       return vehicleDAO.save(vehicle);
    }


    @PutMapping("/{id}")
    public Vehicle editVehicle(@RequestBody Vehicle vehicle, @PathVariable int id){
        checkVehiclePut(vehicle);
        vehicle.setId(id);
        return vehicleDAO.save(vehicle);
    }
    @DeleteMapping("/{id}")
    public Vehicle deleteVehicle(@PathVariable int id){
        return vehicleDAO.deleteById(id);
    }


//    public Object filterByType(@RequestParam String type){
//
//    }




}
