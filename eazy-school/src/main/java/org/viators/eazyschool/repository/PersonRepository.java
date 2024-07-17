package org.viators.eazyschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.viators.eazyschool.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person readByEmail(String email);

}
