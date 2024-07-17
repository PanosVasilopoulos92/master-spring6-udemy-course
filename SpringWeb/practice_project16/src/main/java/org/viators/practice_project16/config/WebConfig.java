package org.viators.practice_project16.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configures the web application's view controllers.
 * This class implements the {@link WebMvcConfigurer} interface to add view controllers for the "/courses" and "/about" URLs.
 * The "/courses" URL will render the "courses" view, and the "/about" URL will render the "about" view.
 * This allows serving static pages to the browser without the need for a dedicated controller.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * This way we do not to create a Controller in order to serve static pages to browser.
     * The mapping between the URL and the view is achieved with the help of a "view controller".
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/courses").setViewName("courses");
        registry.addViewController("/about").setViewName("about");
    }
}
