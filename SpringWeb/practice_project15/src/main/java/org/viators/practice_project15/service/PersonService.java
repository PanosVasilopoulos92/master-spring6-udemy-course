package org.viators.practice_project15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.viators.practice_project15.constants.EazySchoolConstants;
import org.viators.practice_project15.model.Person;
import org.viators.practice_project15.model.Role;
import org.viators.practice_project15.repository.PersonRepository;
import org.viators.practice_project15.repository.RoleRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Role role = roleRepository.getRoleByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (person.getPersonId() > 0)
        {
            isSaved = true;
            System.out.println("Person created");
        }
        return isSaved;
    }
}
