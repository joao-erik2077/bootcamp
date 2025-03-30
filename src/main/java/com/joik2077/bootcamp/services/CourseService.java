package com.joik2077.bootcamp.services;

import com.joik2077.bootcamp.models.Course;
import com.joik2077.bootcamp.repositories.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {
  private final CourseRepository repository;

  public Course createCourse(Course course) {
    course = repository.save(course);
    return course;
  }

  public Set<Course> getAllCourses() {
    return new HashSet<>(repository.findAll());
  }
}
