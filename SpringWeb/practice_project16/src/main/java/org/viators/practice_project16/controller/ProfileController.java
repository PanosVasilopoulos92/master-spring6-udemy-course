package org.viators.practice_project16.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ProfileController {

    @RequestMapping("/displayProfile")
    public ModelAndView displayMessages(Model model){
        ModelAndView modelAndView = new ModelAndView("profile.html");
        return modelAndView;
    }
}
