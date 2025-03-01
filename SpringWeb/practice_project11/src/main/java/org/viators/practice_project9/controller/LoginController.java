package org.viators.practice_project9.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String displayLoginPage(@RequestParam(value = "error", required=false) String error,
                                   @RequestParam(value = "logout", required=false) String logout, Model model) {
        String errorMsg = null;

        if (error != null) {
            errorMsg = "Username or Password is incorrect";
        }

        if (logout != null) {
            errorMsg = "You have been successfully logged out";
        }

        model.addAttribute("errorMsg", errorMsg);
        return "login.html";
    }

}
