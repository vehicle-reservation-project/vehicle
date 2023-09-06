package com.microservice.vehicle.dao;

import com.microservice.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IVehicleDAO extends JpaRepository<Vehicle, Integer> {

    Vehicle findById(int id);

    Vehicle save(Vehicle vehicle);
    Vehicle deleteById(int id);

}
