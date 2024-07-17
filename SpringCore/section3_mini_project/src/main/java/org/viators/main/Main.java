package org.viators.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.viators.beans.Person;
import org.viators.beans.Vehicle;
import org.viators.config.ProjectConfig;
import org.viators.implementations.SonySpeakers;
import org.viators.interfaces.ISpeakers;
import org.viators.services.VehicleServices;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var speakers = context.getBean(SonySpeakers.class);
//        var vehicle1 = new Vehicle("BYD Seal");
        var vehicle1 = context.getBean(Vehicle.class);
        vehicle1.setModel("BYD Seal");
        vehicle1.getVehicleServices().setSpeakers(speakers);
        vehicle1.getVehicleServices().playMusic();
        vehicle1.getVehicleServices().move();
        System.out.println("-".repeat(12));

        var person1 = new Person(vehicle1);
        System.out.println(person1);
        System.out.println(person1.getVehicle());
        System.out.println("-".repeat(12));

        String[] allSpeakers = context.getBeanNamesForType(ISpeakers.class);
        System.out.println(Arrays.toString(allSpeakers));
        System.out.println("-".repeat(12));
        System.out.println();

        VehicleServices vehicleServices1 = context.getBean(VehicleServices.class);
        VehicleServices vehicleServices2 = context.getBean(VehicleServices.class);
        System.out.println("Hashcode of the object vehicleServices1 : " + vehicleServices1.hashCode());
        System.out.println("Hashcode of the object vehicleServices2 : " + vehicleServices2.hashCode());
        if (vehicleServices1.equals(vehicleServices2)) {
            System.out.println("VehicleServices bean is a singleton scoped bean");
        }

    }
}
