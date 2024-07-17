package org.viators.practice_project14.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.viators.practice_project14.model.Contact;
import org.viators.practice_project14.service.ContactService;

import java.util.List;

@Slf4j
@Controller
public class ContactController {

//    private static Logger log = Logger.getLogger(ContactController.class.getName());

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

    @PostMapping(value = "/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) { // This means that I have a specific model attribute that is bound with the "contact" object.
        if (errors.hasErrors()) {
            log.error("Contact form validation has failed due to: " + errors);
            return "contact.html"; // Will not invoke the contact "th:action"
        }

        contactService.saveMessageDetails(contact);
        return "redirect:/contact"; // Will invoke the contact "th:action" (contained in the contact.html file) again from start.
    }

    @RequestMapping("/displayMessages")
    public ModelAndView displayMessages(Model model) {
        List<Contact> contactMsgs = contactService.findMsgsWithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs", contactMsgs);
        return modelAndView;
    }

    @RequestMapping(value = "/closeMsg", method = RequestMethod.GET)
    public String closeMsg(@RequestParam int id) {
        contactService.updateMsgStatus(id);
        return "redirect:/displayMessages";
    }

}
