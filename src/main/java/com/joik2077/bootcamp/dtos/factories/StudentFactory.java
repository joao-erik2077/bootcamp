package com.joik2077.bootcamp.dtos.factories;

import com.joik2077.bootcamp.dtos.requests.StudentCreateDTO;
import com.joik2077.bootcamp.dtos.models.StudentDTO;
import com.joik2077.bootcamp.models.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class StudentFactory {
  private final CourseFactory courseFactory;

  public Student studentCreateDtoToStudent(StudentCreateDTO studentCreateDTO) {
    Student student = new Student();
    student.setName(studentCreateDTO.name());
    return student;
  }

  public Set<StudentDTO> setOfStudentToSetOfStudentDto(Set<Student> students, boolean withCourses) {
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
