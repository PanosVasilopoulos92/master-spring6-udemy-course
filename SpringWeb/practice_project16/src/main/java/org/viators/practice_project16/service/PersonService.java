package org.viators.practice_project16.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.viators.practice_project16.constants.EazySchoolConstants;
import org.viators.practice_project16.model.Person;
import org.viators.practice_project16.model.Role;
import org.viators.practice_project16.repository.PersonRepository;
import org.viators.practice_project16.repository.RoleRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Role role = roleRepository.getRoleByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRole(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if (person.getPersonId() > 0) {
            isSaved = true;
            System.out.println("Person created");
        }
        return isSaved;
    }
}
