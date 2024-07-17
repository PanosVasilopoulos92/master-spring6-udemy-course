package org.viators.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.viators.beans.Vehicle;
import org.viators.config.ProjectConfig;

public class Example1 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel("Honda City");
        System.out.println("Vehicle name from non-spring context is: " + vehicle.getModel());

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle vehicle2 = context.getBean(Vehicle.class);
        System.out.printf("Vehicle name from non-spring context is: %s\n", vehicle2.getModel());

        /*
        We don’t need to do any explicit casting while fetching a bean from context.
        Spring is smart enough to look for a bean of the type you requested in its context.
        !! If such a bean doesn’t exist,Spring will throw an exception !!
        * */
        var hello = context.getBean(String.class);
        System.out.println("String value from Spring Context is: " + hello);

        Integer num = context.getBean(Integer.class);
        System.out.println("Integer value from Spring Context is: " + num);
    }
}
