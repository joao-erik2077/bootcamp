package com.joik2077.bootcamp.dtos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record CourseDTO(
    UUID id,
    String name,
    LocalDateTime createdAt,
    @JsonIgnoreProperties("courses")
    Set<StudentDTO> students
) {
}
