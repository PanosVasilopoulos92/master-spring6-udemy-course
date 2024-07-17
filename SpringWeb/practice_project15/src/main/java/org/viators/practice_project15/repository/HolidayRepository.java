package org.viators.practice_project15.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.viators.practice_project15.model.Holiday;

/*
    @Repository stereotype annotation is used to add a bean of this class
    type to the Spring context and indicate that given Bean is used to perform
    DB related operations.
*/
@Repository
public interface HolidayRepository extends CrudRepository<Holiday, Integer> {

}
