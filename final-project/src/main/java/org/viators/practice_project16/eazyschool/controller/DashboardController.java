package org.viators.practice_project16.eazyschool.controller;


import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.viators.practice_project16.eazyschool.model.Person;
import org.viators.practice_project16.eazyschool.repository.PersonRepository;

@Slf4j
@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;

//    @Value("${eazyschool.pageSize}")
//    private int defaultPageSize;
//
//    @Value("${eazyschool.contact.successMsg}")
//    private String message;

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model,Authentication authentication, HttpSession session) {
        Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        if(null != person.getEazySchoolClass() && null != person.getEazySchoolClass().getName()){
            model.addAttribute("enrolledClass", person.getEazySchoolClass().getName());
        }
        session.setAttribute("loggedInPerson", person);
        return "dashboard.html";
    }

}
