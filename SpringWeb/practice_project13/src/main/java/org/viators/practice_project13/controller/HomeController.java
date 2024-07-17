package org.viators.practice_project13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"", "/", "/home"})
    public String displayHomePage() {
        return "home.html";
    }

//    @RequestMapping(value = {" ", "/", "home"})
//    public String displayHomePage(Model model) {
//        model.addAttribute("username", "Panos Vasilopoulos");
//        return "home.html";
//    }

}
