package org.viators.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.viators.beans.Vehicle;

/*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the application.
* */
@Configuration
public class ProjectConfig {

    /*
    @Bean annotation, which lets Spring know that it needs to call
    this method when it initializes its context and adds the returned
    value to the context.
    * */
    @Bean(name = "Audi") // Custom Bean naming
    Vehicle vehicle1() {
        var veh = new Vehicle();
        veh.setModel("Audi 8");
        return veh;
    }

    @Bean(value = "BYD")
    Vehicle vehicle2() {
        var veh = new Vehicle();
        veh.setModel("BYD Seal");
        return veh;
    }

    /*
    When you have multiple beans of the same kind inside the Spring context,
    you can make one of them primary by using @Primary annotation. Primary bean is
    the one which Spring will choose if it has multiple options, and you don’t specify a name.
    In other words, it is the default bean that Spring Context will consider in case of
    confusion due to multiple beans present of same type.
    * */
    @Primary
    @Bean("Ferrari")
    Vehicle vehicle3() {
        var veh = new Vehicle();
        veh.setModel("Ferrari S4");
        return veh;
    }

}
