package com.joik2077.bootcamp.dtos.factories;

import com.joik2077.bootcamp.dtos.requests.StudentCreateDTO;
import com.joik2077.bootcamp.dtos.models.StudentDTO;
import com.joik2077.bootcamp.models.Student;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StudentFactory {

  public Student studentCreateDtoToStudent(StudentCreateDTO studentCreateDTO) {
    Student student = new Student();
    student.setName(studentCreateDTO.name());
    return student;
  }

  public StudentDTO studentToStudentDto(Student student) {
    CourseFactory courseFactory = new CourseFactory();

    return new StudentDTO(
        student.getId(),
        student.getName(),
        student.getCreatedAt(),
        courseFactory.setOfCourseToSetOfCourseDto(student.getCourses(), false)
    );
  }

  public Set<StudentDTO> setOfStudentToSetOfStudentDto(Set<Student> students, boolean withCourses) {
    CourseFactory courseFactory = new CourseFactory();

    return students.stream().map(
        student -> new StudentDTO(
            student.getId(),
            student.getName(),
            student.getCreatedAt(),
            withCourses ? courseFactory.setOfCourseToSetOfCourseDto(student.getCourses(), false) : null
        )
    ).collect(Collectors.toSet());
  }
}
