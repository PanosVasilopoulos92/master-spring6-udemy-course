package org.viators.practice_project16.eazyschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.viators.practice_project16.eazyschool.model.EazySchoolClass;

@Repository
public interface EazySchoolClassRepository extends JpaRepository<EazySchoolClass, Integer> {

}
