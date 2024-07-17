package org.viators.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class VehicleStartCheckAspect {

    private Logger logger = Logger.getLogger(VehicleStartCheckAspect.class.getName());

    @Before("execution(* org.viators.services.*.*(..)) && args(vehicleStarted,..)")
    public void checkVehicleStarted(JoinPoint joinPoint, boolean vehicleStarted) throws Throwable{
        if (!vehicleStarted){
            logger.log(Level.SEVERE, "Vehicle unable to perform operation");
            throw new RuntimeException("Vehicle not started");
        }
    }
}
