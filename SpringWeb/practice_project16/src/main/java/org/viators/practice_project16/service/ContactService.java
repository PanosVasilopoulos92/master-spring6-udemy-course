package org.viators.practice_project16.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.viators.practice_project16.constants.EazySchoolConstants;
import org.viators.practice_project16.model.Contact;
import org.viators.practice_project16.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Slf4j // Generates logger for this class.
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        Contact savedContact = contactRepository.save(contact);

        if (savedContact.getContactID() > 0) {
            isSaved = true;
        }

        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus() {
        return contactRepository.findByStatus(EazySchoolConstants.OPEN);
    }

    public boolean updateMsgStatus(int contactID) {

        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactID);
        contact.ifPresent(cont -> {
            cont.setStatus(EazySchoolConstants.CLOSE);
        });

        Contact updatedContact = contactRepository.save(contact.get());
        if (updatedContact.getUpdatedBy() != null) {
            isUpdated = true;
        }

        return isUpdated;
    }

}
