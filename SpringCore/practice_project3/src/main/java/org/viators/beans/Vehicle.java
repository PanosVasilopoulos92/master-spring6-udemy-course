package org.viators.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @PostConstruct
    public void initialiseModel(){
        this.model = "Ferrari S4";
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroying Vehicle Bean...");
    }

    public void printHello(){
        System.out.printf("Hello from Component Vehicle (%s) Bean...%n", this.model);
    }
}
