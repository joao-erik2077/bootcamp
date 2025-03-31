package com.joik2077.bootcamp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;

  @ManyToMany
  @JoinTable(
      name = "courses_members_like",
      joinColumns = @JoinColumn(name = "courseId"),
      inverseJoinColumns = @JoinColumn(name = "studentId")
  )
  private List<Student> students = new ArrayList<>();

  private LocalDateTime createdAt = LocalDateTime.now();
}
