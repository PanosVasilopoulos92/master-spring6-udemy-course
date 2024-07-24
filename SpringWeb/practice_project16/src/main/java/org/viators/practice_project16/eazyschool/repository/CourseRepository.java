package org.viators.practice_project16.eazyschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.viators.practice_project16.eazyschool.model.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> getByOrderByName(); // static Sorting of results with 'OrderBy'
    List<Course> getByOrderByNameDesc();
}
