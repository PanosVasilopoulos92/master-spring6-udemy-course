package org.viators.practice_project16.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "HOLIDAYS")
public class Holiday extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private final int holidayID;

    private final String day;

    private final String reason;

    @Enumerated(EnumType.STRING)
    private final Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }

}
