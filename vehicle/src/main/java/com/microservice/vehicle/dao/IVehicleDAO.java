package com.microservice.vehicle.dao;

import com.microservice.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IVehicleDAO extends JpaRepository<Vehicle, Integer> {
    Vehicle save(int id);


}
