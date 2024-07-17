package org.viators.practice_project15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.viators.practice_project15.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
