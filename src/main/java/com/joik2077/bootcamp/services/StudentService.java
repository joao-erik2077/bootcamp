package com.joik2077.bootcamp.services;

import com.joik2077.bootcamp.models.Student;
import com.joik2077.bootcamp.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {
  private final StudentRepository repository;

  public Student createStudent(Student student) {
    student = repository.save(student);
    return student;
  }

  public Set<Student> getAllStudents() {
    return new HashSet<>(repository.findAll());
  }
}
