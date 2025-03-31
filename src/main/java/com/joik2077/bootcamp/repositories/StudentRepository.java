package com.joik2077.bootcamp.repositories;

import com.joik2077.bootcamp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
  List<Student> findAllByOrderByCreatedAt();
}
