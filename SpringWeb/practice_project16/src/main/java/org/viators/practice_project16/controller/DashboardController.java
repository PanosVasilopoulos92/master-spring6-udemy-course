package org.viators.practice_project16.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.viators.practice_project16.model.Person;
import org.viators.practice_project16.repository.PersonRepository;

@Controller
public class DashboardController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session){
        Person person = personRepository.getByEmail(authentication.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        session.setAttribute("loggedInPerson", person);
        return "dashboard.html";
    }
}
