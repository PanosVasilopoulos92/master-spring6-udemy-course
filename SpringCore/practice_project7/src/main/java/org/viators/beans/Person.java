package org.viators.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Panos";

    /*
    The @Autowired annotation marks on a field, constructor, Setter method
    is used to auto-wire the beans that is "injecting beans" (Objects) at runtime
    by Spring Dependency Injection mechanism.
    * */
//    @Autowired // Not the recommended way
    private final Vehicle vehicle;

    @Autowired // The recommended way to wire the Spring Beans is through the Constructor.
    // When having more than one objects of same Type we must specifically tell Spring which
    // one of them we want. By using the @Qualifier annotation is the best way.
    public Person(@Qualifier("vehicle3") Vehicle vehicle) {
        this.vehicle = vehicle;
        System.out.println("Person bean was created in Spring IOC context");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }

    @Override
    public String toString() {
        return "Person's name: " + this.name;
    }
}
