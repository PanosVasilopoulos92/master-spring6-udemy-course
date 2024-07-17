package org.viators.practice_project16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.viators.practice_project16.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person getByEmail(String email);
}
