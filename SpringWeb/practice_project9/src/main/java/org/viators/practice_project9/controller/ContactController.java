package org.viators.practice_project9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.viators.practice_project9.model.Contact;
import org.viators.practice_project9.service.ContactService;

import java.util.logging.Logger;

@Controller
public class ContactController {

    private static Logger logger = Logger.getLogger(ContactController.class.getName());

    private final ContactService contactService = new ContactService();

    @RequestMapping("/contact")
    public String displayContactPage() {
        return "contact.html";
    }

    /*
    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
//    @PostMapping(value = "/saveMsg")
    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
                                    @RequestParam String email, @RequestParam String subject,
                                    @RequestParam String message) {
        logger.log(Level.INFO, "Name: " + name);
        logger.log(Level.INFO, "MobileNum: " + mobileNum);
        logger.log(Level.INFO, "Email: " + email);
        logger.log(Level.INFO, "Subject: " + subject);
        logger.log(Level.INFO, "Message: " + message);
        return new ModelAndView("redirect:/contact"); // With ModelAndView I can send both Data and a View to The UI.
    }
    */

    @PostMapping(value = "saveMsg")
    public ModelAndView saveMessage(Contact contact) {
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }

}
