package org.viators.practice_project9.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication){
        model.addAttribute("username", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        throw new RuntimeException("It' been a difficult day..."); // In order to display the global error page
//        return "dashboard.html";
    }
}
