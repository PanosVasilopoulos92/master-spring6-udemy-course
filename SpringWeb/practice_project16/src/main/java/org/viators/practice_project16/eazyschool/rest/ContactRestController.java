package org.viators.practice_project16.eazyschool.rest;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.viators.practice_project16.eazyschool.constants.EazySchoolConstants;
import org.viators.practice_project16.eazyschool.model.Contact;
import org.viators.practice_project16.eazyschool.model.Response;
import org.viators.practice_project16.eazyschool.repository.ContactRepository;

import java.util.List;

/*
 * Rest services with MVC style
 */
@Slf4j
//@Controller
@RestController // @RestController is the combination of @Controller + @ResponseBody
@RequestMapping(path = "/api/contact", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@CrossOrigin(origins = "*")
public class ContactRestController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/getMessagesByStatus")
//    @ResponseBody
    public List<Contact> getMessagesByStatus(@RequestParam(name = "status") String status) {
        return contactRepository.findByStatus(status, Sort.by("name"));
    }

    @GetMapping("/getMsgsByStatus")
//    @ResponseBody
    public List<Contact> getMsgsByStatus(@RequestBody Contact contact) {
        if (contact == null || contact.getStatus() == null) {
            return List.of();
        }

        return contactRepository.findByStatus(contact.getStatus(), Sort.by("name"));
    }

    @PostMapping("/saveMsg")
    public ResponseEntity<Response> saveMsg(@RequestHeader("invocationFrom") String invocationFrom,
                                            @Valid @RequestBody Contact contact) {
        log.info(String.format("Header invocationFrom: %s", invocationFrom));
        contactRepository.save(contact);
//        Response response2 =  new Response("201", "Message successfully saved");
        Response response = new Response();
        response.setStatusCode("201");
        response.setStatusMsg("Message successfully saved");
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("isMsgSaved", "true")
                .body(response);
    }

    @DeleteMapping("/deleteMsg")
    public ResponseEntity<Response> deleteMsg(RequestEntity<Contact> contactRequestEntity) {
        if (contactRequestEntity == null || contactRequestEntity.getBody() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Response(HttpStatus.BAD_REQUEST.toString(), "Invalid request"));
        }

        Contact contact = contactRequestEntity.getBody();

        try {
            boolean wasFound = contactRepository.existsById(contact.getContactId());
            if (wasFound) {
                contactRepository.deleteById(contact.getContactId());
                return ResponseEntity.status(HttpStatus.OK).body(new Response("200", "Message successfully deleted"));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new Response(HttpStatus.BAD_REQUEST.toString(), "Invalid request, no such message exist in database."));
            }
        } catch (Exception e) {
            log.error("Message could not be deleted");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Message could not be deleted"));
        }
    }

    @PatchMapping("/closeMsg")
    public ResponseEntity<Response> closeMsg(@RequestParam int contactId) {
//        if (contactId <= 0) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("400", "Invalid id"));
//        }

        int result = contactRepository.updateStatusById(EazySchoolConstants.CLOSE, contactId);

        if (result > 0 && contactRepository.findById(contactId).get().getStatus().equals("Open")) {
            return ResponseEntity.status(HttpStatus.OK).body(new Response("200", "Message closed"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("400", "Invalid contact ID or message already closed"));
        }
    }

}
