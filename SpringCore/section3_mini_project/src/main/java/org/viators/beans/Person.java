package org.viators.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "personBean")
public class Person {
    private String name = "Panos";
    private final Vehicle vehicle;

    @Autowired
    public Person(@Qualifier("vehicleBean") Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
