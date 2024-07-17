package org.viators.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "org.viators.implementations",
        "org.viators.services", "org.viators. aspects" })
@EnableAspectJAutoProxy
public class ProjectConfig {
}
