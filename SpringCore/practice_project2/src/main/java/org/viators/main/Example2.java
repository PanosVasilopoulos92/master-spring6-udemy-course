package org.viators.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.viators.beans.Vehicle;
import org.viators.config.ProjectConfig;

public class Example2 {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle vehicle1 = context.getBean("Audi", Vehicle.class);
        System.out.printf("Vehicle name from non-spring context is: %s\n", vehicle1.getModel());

        Vehicle vehicle2 = context.getBean("BYD", Vehicle.class);
        System.out.printf("Vehicle name from non-spring context is: %s\n", vehicle2.getModel());

        Vehicle vehicle3 = context.getBean("Ferrari", Vehicle.class);
        System.out.printf("Vehicle name from non-spring context is: %s\n", vehicle3.getModel());

        Vehicle vehicle4 = context.getBean(Vehicle.class); // Will get the vehicle that has the @Primary annotation.
        System.out.printf("Vehicle name from non-spring context is: %s\n", vehicle4.getModel());
    }
}
