package com.joik2077.bootcamp.dtos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record StudentDTO(
    UUID id,
    String name,
    LocalDateTime createdAt,
    @JsonIgnoreProperties("students")
    Set<CourseDTO> courses
) {
}
