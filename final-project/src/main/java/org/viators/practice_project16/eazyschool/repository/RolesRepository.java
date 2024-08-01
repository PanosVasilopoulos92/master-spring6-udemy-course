package org.viators.practice_project16.eazyschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.viators.practice_project16.eazyschool.model.Roles;

@Repository
@RepositoryRestResource(path = "roles")
public interface RolesRepository extends JpaRepository<Roles, Integer> {

    Roles getByRoleName(String roleName);
}
