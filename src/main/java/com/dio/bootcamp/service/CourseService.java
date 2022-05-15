package com.dio.bootcamp.service;

import com.dio.bootcamp.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dio.bootcamp.model.Course;

@Service
public class CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private Course course;

  private static final double XP_DEFAULT = 10d;

  public List<Course> findAll() {
    return (List<Course>) courseRepository.findAll();
  }

  public Optional<Course> findById(UUID id) {
    Optional<Course> result = courseRepository.findById(id);

    if (result.isEmpty()) {
      throw new RuntimeException("Course not found");
    }

    return result;
  }

  public Course save(Course course) {
    try {
      return courseRepository.save(course);
    } catch (Exception e) {
      throw new RuntimeException("failure to save Course.");
    }
  }

  public Course update(Course course) {
    Optional<Course> obj = findById(course.getId());

    try {
      course.setId(obj.get().getId());
      return courseRepository.save(course);
    } catch (Exception e) {
      throw new RuntimeException("failure to update Course.");
    }
  }

  public void delete(UUID id) {
    Optional<Course> obj = findById(id);

    try {
      courseRepository.delete(obj.get());
    } catch (Exception e) {
      throw new RuntimeException("failure to delete Course.");
    }
  }

  public double calculateXp() {
    return XP_DEFAULT + course.getWorkload();
  }
}
