package org.viators.eazyschool.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.viators.eazyschool.constants.EazySchoolConstants;
import org.viators.eazyschool.model.Person;
import org.viators.eazyschool.model.Roles;
import org.viators.eazyschool.repository.PersonRepository;
import org.viators.eazyschool.repository.RolesRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
