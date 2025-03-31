package com.joik2077.bootcamp.dtos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CourseDTO(
    UUID id,
    String name,
    LocalDateTime createdAt,
    @JsonIgnoreProperties("courses")
    List<StudentDTO> students
) {
}
