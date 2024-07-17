package org.viators.beans;

public class Person {
    private String name;
    private Vehicle vehicle;

    public Person() {
        System.out.println("Person bean was created in Spring IOC context");
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

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Person's name: " + this.name;
    }
}
