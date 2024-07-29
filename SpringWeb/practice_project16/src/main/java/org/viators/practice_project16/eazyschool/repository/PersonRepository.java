package org.viators.practice_project16.eazyschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.viators.practice_project16.eazyschool.model.Person;

@Repository
@RepositoryRestResource(exported = false)
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person readByEmail(String email);

}
