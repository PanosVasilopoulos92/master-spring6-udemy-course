package org.viators.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.viators.config.ProjectConfig;
import org.viators.model.Song;
import org.viators.services.VehicleServices;

/* This project corresponds to section 5: Aspect Oriented Programming (AOP) inside Spring framework */
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var vehicleServices = context.getBean(VehicleServices.class);
        System.out.println(vehicleServices.getClass());
        Song song = new Song();
        song.setTitle("Red Space");
        song.setSingerName("Taylor Swift");
        boolean vehicleStarted = true;
        String moveVehicleStatus = vehicleServices.moveVehicle(vehicleStarted);
        String playMusicStatus = vehicleServices.playMusic(vehicleStarted, song);
        String applyBrakeStatus = vehicleServices.applyBrake(vehicleStarted);
    }

}
