package com.joik2077.bootcamp.repositories;

import com.joik2077.bootcamp.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
  List<Course> findAllByOrderByCreatedAt();
}
