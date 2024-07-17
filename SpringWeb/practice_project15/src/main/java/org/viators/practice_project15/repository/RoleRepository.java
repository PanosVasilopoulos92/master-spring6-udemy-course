package org.viators.practice_project15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.viators.practice_project15.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role getRoleByRoleName(String roleName);
}
