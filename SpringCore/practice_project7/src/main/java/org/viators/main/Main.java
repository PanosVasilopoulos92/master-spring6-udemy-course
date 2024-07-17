package org.viators.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.viators.beans.Person;
import org.viators.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {
       var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);

        System.out.println("Person name from Spring Context is: " + person.getName());
        System.out.println("Vehicle that Person owns is: " + person.getVehicle());

    }
}
