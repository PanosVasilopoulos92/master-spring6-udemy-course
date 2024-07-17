package org.viators.practice_project9.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.viators.practice_project9.model.Contact;
import org.viators.practice_project9.service.ContactService;

@Slf4j
@Controller
public class ContactController {

//    private static Logger log = Logger.getLogger(ContactController.class.getName());

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

//    @RequestMapping("/contact")
//    public String displayContactPage() {
//        return "contact.html";
//    }

    /*
    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
//    @PostMapping(value = "/saveMsg")
    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
                                    @RequestParam String email, @RequestParam String subject,
                                    @RequestParam String message) {
        log.log(Level.INFO, "Name: " + name);
        log.log(Level.INFO, "MobileNum: " + mobileNum);
        log.log(Level.INFO, "Email: " + email);
        log.log(Level.INFO, "Subject: " + subject);
        log.log(Level.INFO, "Message: " + message);
        return new ModelAndView("redirect:/contact"); // With ModelAndView I can send both Data and a View to The UI.
    }
    */

    @RequestMapping(value = "/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

    @PostMapping(value = "saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) { // This means that I have a specific model attribute that is bound with the "contact" object.
        if (errors.hasErrors()) {
            log.error("Contact form validation has failed due to: " + errors);
            return "contact.html"; // Will not invoke the contact "th:action"
        }

        contactService.saveMessageDetails(contact);
        return "redirect:/contact"; // Will invoke the contact "th:action" (contained in the contact.html file) again from start.
    }

}
