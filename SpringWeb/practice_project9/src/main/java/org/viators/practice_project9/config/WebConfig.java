package org.viators.practice_project9.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Adds a view controller for the "/courses" URL, which will render the "courses" view.
     * This way we do not to create a Controller in order to serve static pages to browser.
     * The mapping between the URL and the view is achieved with the help of a "view controller".
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/courses").setViewName("courses");
        registry.addViewController("/about").setViewName("about");
    }
}
