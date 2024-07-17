package org.viators.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.viators.beans.Vehicle;

/*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the application.

To tell Spring it needs to search for classes annotated
with stereotype annotations, we use the @ComponentScan annotation over the
configuration class.
* */
@Configuration
@ComponentScan(basePackages = "org.viators.beans")
public class ProjectConfig {

    /*
    @Bean annotation, which lets Spring know that it needs to call
    this method when it initializes its context and adds the returned
    value to the context.
    * */
    @Bean
    Vehicle vehicle1() {
        var veh = new Vehicle();
        veh.setModel("Audi rx8");
        return veh;
    }

    @Bean
//    @Primary
    Vehicle vehicle2() {
        var veh = new Vehicle();
        veh.setModel("Honda R2");
        return veh;
    }

    @Bean
    Vehicle vehicle3() {
        var veh = new Vehicle();
        veh.setModel("Ferrari S4");
        return veh;
    }

}