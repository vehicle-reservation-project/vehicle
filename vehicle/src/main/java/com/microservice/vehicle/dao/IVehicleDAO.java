package com.microservice.vehicle.dao;

import com.microservice.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IVehicleDAO extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findByType(String type);

    Vehicle findById(int id);

    Vehicle save(Vehicle vehicle);
    Vehicle deleteById(int id);

    List<Vehicle> findByFiscalHPowerIsLessThan(int maxPower);

}
