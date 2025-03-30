package com.joik2077.bootcamp.services;

import com.joik2077.bootcamp.models.Course;
import com.joik2077.bootcamp.repositories.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
  private final CourseRepository repository;

  public Course createCourse(Course course) {
    course = repository.save(course);
    return course;
  }

  public List<Course> getAllCourses() {
    return repository.findAll();
  }
}
