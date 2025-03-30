package com.joik2077.bootcamp.dtos.factories;

import com.joik2077.bootcamp.dtos.requests.CourseCreateDTO;
import com.joik2077.bootcamp.dtos.models.CourseDTO;
import com.joik2077.bootcamp.models.Course;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CourseFactory {
  private final StudentFactory studentFactory;

  public Course courseCreateDtoToCourse(CourseCreateDTO courseCreateDTO) {
    Course course = new Course();
    course.setName(courseCreateDTO.name());
    return course;
  }

  public Set<CourseDTO> setOfCourseToSetOfCourseDto(Set<Course> courses, boolean withStudents) {
    return courses.stream().map(
        course -> new CourseDTO(
            course.getId(),
            course.getName(),
            course.getCreatedAt(),
            withStudents ? studentFactory.setOfStudentToSetOfStudentDto(course.getStudents(), false) : null
        )
    ).collect(Collectors.toSet());
  }
}
