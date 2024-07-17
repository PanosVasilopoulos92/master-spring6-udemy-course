package org.viators.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggerAspect {

    private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    @Around("execution(* org.viators.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.getSignature().toString() + " method execution started.");
        Instant start = Instant.now();
        System.out.println(start);
        joinPoint.proceed(); // Invokes the method.
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("method execution finished.");
        logger.info("Method executed in: " + timeElapsed);
    }

    @AfterThrowing(value = "execution(* org.viators.services.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        logger.log(Level.SEVERE, joinPoint.getSignature() + " " + ex.getMessage());
    }

    @AfterReturning(value = "execution(* org.viators.services.*.*(..))", returning = "retVal")
    public void logStatus(JoinPoint joinPoint, String retVal) {
        logger.log(Level.INFO, joinPoint.getSignature() + " " + retVal);
    }

}
