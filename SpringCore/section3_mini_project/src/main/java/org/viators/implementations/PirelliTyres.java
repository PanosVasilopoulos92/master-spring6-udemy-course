package org.viators.implementations;

import org.springframework.stereotype.Component;
import org.viators.interfaces.ITyres;

@Component
public class PirelliTyres implements ITyres {
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void rotate() {
        System.out.println("Pirelli tyres are rotating...");
    }
}
