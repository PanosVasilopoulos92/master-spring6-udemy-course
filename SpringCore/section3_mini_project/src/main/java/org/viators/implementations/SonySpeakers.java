package org.viators.implementations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.viators.interfaces.ISpeakers;

@Component
@Primary
public class SonySpeakers implements ISpeakers {
//    private String model;
//
//    public SonySpeakers() {
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }

    @Override
    public void makeSound() {
        System.out.println("Sony speakers are on. Playing music now...");
    }
}
