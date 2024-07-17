package org.viators.practice_project12.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.viators.practice_project12.constants.EazySchoolConstants;
import org.viators.practice_project12.model.Contact;
import org.viators.practice_project12.repository.ContactRepository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j // Generates logger for this class.
@Service
public class ContactService {

//    private static Logger log = Logger.getLogger(ContactService.class.getName());

    @Autowired
    private ContactRepository contactRepository;

    /**
     * Saves the details of a contact.
     *
     * @param contact the contact to save
     * @return true if the contact was saved successfully, false otherwise
     */
    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMessage(contact);

        if (result > 0) {
            isSaved = true;
        }

        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(EazySchoolConstants.OPEN);
        return contactMsgs;
    }
}
