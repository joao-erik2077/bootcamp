package com.joik2077.bootcamp.controllers;

import com.joik2077.bootcamp.dtos.factories.StudentFactory;
import com.joik2077.bootcamp.dtos.models.StudentDTO;
import com.joik2077.bootcamp.dtos.requests.StudentCreateDTO;
import com.joik2077.bootcamp.models.Student;
import com.joik2077.bootcamp.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
  private final StudentService service;
  private final StudentFactory factory;

  @PostMapping("/create")
  public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentCreateDTO request) {
    Student student = factory.studentCreateDtoToStudent(request);
    student = service.createStudent(student);

    StudentDTO response = factory.studentToStudentDto(student);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping("/all")
  public ResponseEntity<List<StudentDTO>> getAllStudents() {
    List<Student> students = service.getAllStudents();

    List<StudentDTO> response = factory.listOfStudentToListOfStudentDto(students, true);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }
}
