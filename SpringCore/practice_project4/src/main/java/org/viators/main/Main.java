package org.viators.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.viators.beans.Vehicle;
import org.viators.config.ProjectConfig;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setModel("Audi s2");
        Supplier<Vehicle> audiSupplier = () -> vehicle1;

        Supplier<Vehicle> BYDSupplier = () -> {
            Vehicle vehicle2 = new Vehicle();
            vehicle2.setModel("BYD Seal");
            return vehicle2;
        };

        System.out.println(vehicle1.getModel());

    }
}
