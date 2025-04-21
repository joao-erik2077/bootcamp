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

import java.util.List;
import java.util.Set;
import java.util.UUID;

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
  public ResponseEntity<List<CourseDTO>> getAllCourses() {
    List<Course> courses = service.getAllCourses();

    List<CourseDTO> response = factory.listOfCourseToListOfCourseDto(courses, true);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PostMapping("/{courseId}/students/{studentId}")
  public ResponseEntity<CourseDTO> addStudentToCourse(@PathVariable UUID courseId, @PathVariable UUID studentId) {
    Course course = service.addStudentToCourse(courseId, studentId);

    CourseDTO response = factory.courseToCourseDto(course);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
