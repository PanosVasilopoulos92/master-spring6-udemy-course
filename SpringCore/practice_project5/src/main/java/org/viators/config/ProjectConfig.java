package org.viators.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.viators.beans.Person;
import org.viators.beans.Vehicle;

/*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the application.

To tell Spring it needs to search for classes annotated
with stereotype annotations, we use the @ComponentScan annotation over the configuration
class.
* */
@Configuration
//@ComponentScan(basePackages = "org.viators.beans")
public class ProjectConfig {

    @Bean
    public Vehicle vehicle() {
        var vehicle = new Vehicle();
        vehicle.setModel("BYD Seal");
        return vehicle;
    }

    /*
    Here in the code below, we are trying to wire or establish a relationship between Person and
    Vehicle, by invoking the vehicle() bean method from person() bean method.
    !! Spring will make sure to have only 1 vehicle bean created and also vehicle bean will always
    be created first, as person bean has dependency on it. !!
    * */
//    @Bean
//    public Person person(){
//        var person = new Person();
//        person.setName("Panos");
//        person.setVehicle(vehicle()); // Wiring Beans using method call.
//        return person;
//    }

    /*
    Here in the code below, we are trying to wire or establish a relationship between Person
    and Vehicle, by passing the vehicle as a method parameter to the person() bean method.

    Spring injects the vehicle bean to the person bean using Dependency Injection. Spring will
    make sure to have only 1 vehicle bean is created and also vehicle bean will be created
    first always as person bean has dependency on it.

    * */
    @Bean
    public Person person(Vehicle vehicle){
        var person = new Person();
        person.setName("Panos");
        person.setVehicle(vehicle); // Wiring Beans using method parameters.
        return person;
    }


}
