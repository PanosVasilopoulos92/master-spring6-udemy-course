package org.viators.practice_project9.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.viators.practice_project9.model.Contact;

import java.util.logging.Logger;

@Slf4j // Generates logger for this class.
@Service
public class ContactService {

//    private static Logger log = Logger.getLogger(ContactService.class.getName());

    /**
     * Saves the details of a contact.
     *
     * @param contact the contact to save
     * @return true if the contact was saved successfully, false otherwise
     */
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;

        log.info(contact.toString());
        return isSaved;
    }
}
