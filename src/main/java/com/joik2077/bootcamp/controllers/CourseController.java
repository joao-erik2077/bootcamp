package com.joik2077.bootcamp.controllers;

import com.joik2077.bootcamp.dtos.factories.CourseFactory;
import com.joik2077.bootcamp.dtos.models.CourseDTO;
import com.joik2077.bootcamp.dtos.requests.CourseCreateDTO;
import com.joik2077.bootcamp.models.Course;
import com.joik2077.bootcamp.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {
  private final CourseService service;
  private final CourseFactory factory;

  @PostMapping("/create")
  public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseCreateDTO request) {
    Course course = factory.courseCreateDtoToCourse(request);
    course = service.createCourse(course);

    CourseDTO response = factory.courseToCourseDto(course);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping("/all")
  public ResponseEntity<Set<CourseDTO>> getAllCourses() {
    Set<Course> courses = service.getAllCourses();

    Set<CourseDTO> response = factory.setOfCourseToSetOfCourseDto(courses, true);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }
}
