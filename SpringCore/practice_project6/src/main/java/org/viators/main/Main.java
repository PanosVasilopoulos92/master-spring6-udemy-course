package org.viators.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.viators.beans.Person;
import org.viators.beans.Vehicle;
import org.viators.config.ProjectConfig;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
       var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
        Vehicle vehicle = context.getBean(Vehicle.class);

        System.out.println(person.getName());
        System.out.println(vehicle.getModel());
        System.out.println(person.getName() + "'s car is a " + person.getVehicle());

    }
}
