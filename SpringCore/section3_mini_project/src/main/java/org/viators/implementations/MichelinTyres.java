package org.viators.implementations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.viators.interfaces.ITyres;

@Component
@Primary
public class MichelinTyres implements ITyres {
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void rotate() {
        System.out.println("Michelin tyres are rotating...");
    }
}
