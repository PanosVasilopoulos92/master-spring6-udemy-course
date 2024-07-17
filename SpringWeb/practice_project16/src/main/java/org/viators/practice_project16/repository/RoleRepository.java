package org.viators.practice_project16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.viators.practice_project16.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role getRoleByRoleName(String roleName);
}
