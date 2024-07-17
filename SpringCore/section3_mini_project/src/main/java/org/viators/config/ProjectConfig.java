package org.viators.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.viators.implementations",
            "org.viators.services"})
@ComponentScan(basePackageClasses = { org.viators.beans.Vehicle.class,
        org.viators.beans.Person.class })
public class ProjectConfig {

}
