package com.joik2077.bootcamp.dtos.factories;

import com.joik2077.bootcamp.dtos.requests.CourseCreateDTO;
import com.joik2077.bootcamp.dtos.models.CourseDTO;
import com.joik2077.bootcamp.models.Course;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseFactory {

  public Course courseCreateDtoToCourse(CourseCreateDTO courseCreateDTO) {
    Course course = new Course();
    course.setName(courseCreateDTO.name());
    return course;
  }

  public CourseDTO courseToCourseDto(Course course) {
    StudentFactory studentFactory = new StudentFactory();

    return new CourseDTO(
        course.getId(),
        course.getName(),
        course.getCreatedAt(),
        studentFactory.listOfStudentToListOfStudentDto(course.getStudents(), false)
    );
  }

  public List<CourseDTO> listOfCourseToListOfCourseDto(List<Course> courses, boolean withStudents) {
    StudentFactory studentFactory = new StudentFactory();

    return courses.stream().map(
        course -> new CourseDTO(
            course.getId(),
            course.getName(),
            course.getCreatedAt(),
            withStudents ? studentFactory.listOfStudentToListOfStudentDto(course.getStudents(), false) : null
        )
    ).toList();
  }
}
