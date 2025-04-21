package com.joik2077.bootcamp.services;

import com.joik2077.bootcamp.models.Student;
import com.joik2077.bootcamp.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentService {
  private final StudentRepository repository;

  public Student createStudent(Student student) {
    student = repository.save(student);
    return student;
  }

  public List<Student> getAllStudents() {
    return repository.findAllByOrderByCreatedAt();
  }

  public Student findById(UUID id) throws ResponseStatusException {
    return repository.findById(id).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
    );
  }
}
