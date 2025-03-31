package com.joik2077.bootcamp.dtos.factories;

import com.joik2077.bootcamp.dtos.requests.StudentCreateDTO;
import com.joik2077.bootcamp.dtos.models.StudentDTO;
import com.joik2077.bootcamp.models.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

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
        courseFactory.listOfCourseToListOfCourseDto(student.getCourses(), false)
    );
  }

  public List<StudentDTO> listOfStudentToListOfStudentDto(List<Student> students, boolean withCourses) {
    CourseFactory courseFactory = new CourseFactory();

    return students.stream().map(
        student -> new StudentDTO(
            student.getId(),
            student.getName(),
            student.getCreatedAt(),
            withCourses ? courseFactory.listOfCourseToListOfCourseDto(student.getCourses(), false) : null
        )
    ).toList();
  }
}
