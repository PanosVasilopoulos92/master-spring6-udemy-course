package org.viators.practice_project16.eazyschool.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.viators.practice_project16.eazyschool.constants.EazySchoolConstants;
import org.viators.practice_project16.eazyschool.model.Contact;
import org.viators.practice_project16.eazyschool.repository.ContactRepository;

import java.util.List;

/*
@Slf4j, is a Lombok-provided annotation that will automatically generate an SLF4J
Logger static property in the class at compilation time.
* */
@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;


    /**
     * Save Contact Details into DB
     *
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if (null != savedContact && savedContact.getContactId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus() {
        return contactRepository.findByStatus(EazySchoolConstants.OPEN, Sort.by("name"));
    }

    public Page<Contact> findMsgsWithOpenStatusPageable(int pageNum, String sortField, String sortDir) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());

        return contactRepository.getByStatus(EazySchoolConstants.OPEN, pageable);
    }

    public boolean updateMsgStatus(int contactId) {
        boolean isUpdated = false;

        int row = contactRepository.updateStatusById(EazySchoolConstants.CLOSE, contactId);
        if (row > 0) {
            isUpdated = true;
        }

        return isUpdated;
    }

}
