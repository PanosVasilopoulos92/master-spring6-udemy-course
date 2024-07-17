package org.viators.eazyschool.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.viators.eazyschool.model.EazyClass;

@Repository
public interface EazyClassRepository extends JpaRepository<EazyClass, Integer> {

}
