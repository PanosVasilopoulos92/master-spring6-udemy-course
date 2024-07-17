package org.viators.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.viators.interfaces.ISpeakers;
import org.viators.interfaces.ITyres;
import org.viators.interfaces.IVehicleServices;

@Component
//@Scope(BeanDefinition.SCOPE_SINGLETON)
public class VehicleServices implements IVehicleServices {
    @Autowired
    private ISpeakers speakers;
    private ITyres tyres;

//    @Autowired
//    public VehicleServices(@Qualifier("sonySpeakers") ISpeakers speakers) {
//        this.speakers = speakers;
//    }

    public ISpeakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(ISpeakers speakers) {
        this.speakers = speakers;
    }

    public ITyres getTyres() {
        return tyres;
    }

    @Autowired // not a good practice, just for practice purposes
    public void setTyres(ITyres tyres) {
        this.tyres = tyres;
    }

    @Override
    public void playMusic() {
        speakers.makeSound();
    }

    @Override
    public void move() {
        tyres.rotate();
    }
}
