package org.viators.practice_project15.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viators.practice_project15.model.Person;
import org.viators.practice_project15.service.PersonService;

@Slf4j
@Controller
@RequestMapping("/public")
public class PublicController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String displayRegisterPage(Model model) {
        model.addAttribute("person", new Person());
        return "register.html";
    }

    @PostMapping(value = "/createUser")
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors) {
        if (errors.hasErrors()) {
            return "register.html";
        }

        boolean isSaved = personService.createNewPerson(person);
        if (isSaved){
            return "redirect:/login?register=true";
        } else {
            return "register.html";
        }
    }

}
