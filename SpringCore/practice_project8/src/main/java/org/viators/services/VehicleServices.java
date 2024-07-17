package org.viators.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.viators.interfaces.Speakers;
import org.viators.interfaces.Tyres;
import org.viators.model.Song;

import java.util.logging.Logger;

@Component
public class VehicleServices {
    private Logger logger = Logger.getLogger(VehicleServices.class.getName());

    @Autowired
    private Speakers speakers;
    private Tyres tyres;


    /**
     * Plays the specified song through the vehicle's speakers.
     *
     * @param vehicleStarted Indicates whether the vehicle has been started.
     * @param song The song to be played.
     * @return The sound produced by the speakers.
     */
    public String playMusic(boolean vehicleStarted, Song song) {
        /* All statements that are commented are now executed by aspects. */

//        Instant start = Instant.now();
//        logger.info("method execution started.");

//        if (vehicleStarted) {
//            String music = speakers.makeSound(song);
//        } else {
//            logger.log(Level.SEVERE, "Vehicle unable to perform operation");
//        }

//        Instant end = Instant.now();
//        logger.info("method execution ended.");

//        long timeElapsed = Duration.between(start, end).toMillis();
//        logger.info("Method executed in: " + timeElapsed);

        return speakers.makeSound(song);
    }

    /**
     * Moves the vehicle by rotating the tires.
     *
     * @param vehicleStarted Indicates whether the vehicle has been started.
     * @return The status of the tire rotation operation.
     */
    public String moveVehicle(boolean vehicleStarted) {
        /* All statements that are commented are now executed by aspects. */

//        Instant start = Instant.now();
//        logger.info("method execution start");

//        String status = null;
//        if (vehicleStarted) {
//            status = tyres.rotate();
//        } else {
//            logger.log(Level.SEVERE, "Vehicle not started performing the operation");
//        }

//        logger.info("method execution end");
//        Instant finish = Instant.now();

//        long timeElapsed = Duration.between(start, finish).toMillis();
//        logger.info("Time took to execute the method : " + timeElapsed);

        return tyres.rotate();
    }

    /**
     * Applies the brake to the vehicle.
     *
     * @param vehicleStarted Indicates whether the vehicle has been started.
     * @return A message indicating the brake has been applied.
     */
    public String applyBrake(boolean vehicleStarted) {
        /* All statements that are commented are now executed by aspects. */

//        Instant start = Instant.now();
//        logger.info("method execution start");

//        String status = null;
//        if (vehicleStarted) {
//            status = tyres.stop();
//        } else {
//            logger.log(Level.SEVERE, "Vehicle not started performing the operation");
//        }

//        logger.info("method execution end");
//        Instant finish = Instant.now();

//        long timeElapsed = Duration.between(start, finish).toMillis();
//        logger.info("Time took to execute the method : " + timeElapsed);

        return tyres.stop();
    }

    public Speakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public Tyres getTyres() {
        return tyres;
    }

    @Autowired
    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }
}
