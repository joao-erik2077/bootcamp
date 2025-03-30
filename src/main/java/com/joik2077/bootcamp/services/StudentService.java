package com.joik2077.bootcamp.services;

import com.joik2077.bootcamp.models.Student;
import com.joik2077.bootcamp.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
  private final StudentRepository repository;

  public Student createStudent(Student student) {
    student = repository.save(student);
    return student;
  }

  public List<Student> getAllStudents() {
    return repository.findAll();
  }
}
