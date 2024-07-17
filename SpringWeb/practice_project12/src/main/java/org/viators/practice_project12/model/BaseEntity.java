package org.viators.practice_project12.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
