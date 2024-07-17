package org.viators.implementations;

import org.springframework.stereotype.Component;
import org.viators.interfaces.ISpeakers;

@Component
public class BoseSpeakers implements ISpeakers {
//    private String model;
//
//    public BoseSpeakers() {}
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
        System.out.println("Bose speakers are on. Playing music now...");
    }
}
