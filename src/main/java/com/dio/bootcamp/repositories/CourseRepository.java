package com.dio.bootcamp.repositories;

import java.util.Optional;
import java.util.UUID;

import com.dio.bootcamp.model.Course;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

  public Optional<Course> findById(UUID id);

  public Optional<Course> findByTitle(String Title);

}
