package org.viators.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.viators.services.VehicleServices;

@Component(value = "vehicleBean")
public class Vehicle {
    private String model;
    private final VehicleServices vehicleServices;

    @Autowired
    public Vehicle(VehicleServices vehicleServices) {
        this.vehicleServices = vehicleServices;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleServices getVehicleServices() {
        return vehicleServices;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
