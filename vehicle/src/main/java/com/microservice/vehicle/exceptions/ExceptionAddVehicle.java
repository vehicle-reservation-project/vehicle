package com.microservice.vehicle.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExceptionAddVehicle extends ResponseStatusException {
    public ExceptionAddVehicle() {
        super(HttpStatus.NOT_FOUND, "your entry is not valid!");
    }

}
