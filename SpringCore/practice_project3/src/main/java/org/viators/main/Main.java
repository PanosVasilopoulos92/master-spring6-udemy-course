package org.viators.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.viators.beans.Vehicle;
import org.viators.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var vehicle1 = context.getBean(Vehicle.class);
        System.out.println(vehicle1.getModel());

        vehicle1.printHello();

        context.close();
    }
}
