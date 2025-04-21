package com.joik2077.bootcamp.services;

import com.joik2077.bootcamp.models.Course;
import com.joik2077.bootcamp.models.Student;
import com.joik2077.bootcamp.repositories.CourseRepository;
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
public class CourseService {
  private final CourseRepository repository;
  private final StudentService studentService;

  public Course createCourse(Course course) {
    course = repository.save(course);
    return course;
  }

  public List<Course> getAllCourses() {
    return repository.findAllByOrderByCreatedAt();
  }

  public Course findById(UUID id) {
    return repository.findById(id).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
    );
  }

  public Course addStudentToCourse(UUID courseId, UUID studentId) throws ResponseStatusException {
    Course course = findById(courseId);
    Student student = studentService.findById(studentId);

    List<Student> courseStudents = course.getStudents();

    if (courseStudents.contains(student)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    courseStudents.add(student);
    course.setStudents(courseStudents);

    return repository.save(course);
  }
}
