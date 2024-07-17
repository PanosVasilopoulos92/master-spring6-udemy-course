package org.viators.practice_project16.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ROLES")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int roleId;

    private String roleName;
}
