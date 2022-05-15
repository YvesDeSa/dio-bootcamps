package com.dio.bootcamp.service;

import com.dio.bootcamp.repositories.DeveloperRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dio.bootcamp.model.Course;
import com.dio.bootcamp.model.Developer;
import com.dio.bootcamp.model.Mentorship;

@Service
public class DeveloperService {

  @Autowired
  private DeveloperRepository DeveloperRepository;

  @Autowired
  private Developer Developer;

  public List<Developer> findAll() {
    return (List<Developer>) DeveloperRepository.findAll();
  }

  public Optional<Developer> findById(UUID id) {
    Optional<Developer> result = DeveloperRepository.findById(id);

    if (result.isEmpty()) {
      throw new RuntimeException("Developer not found");
    }

    return result;
  }

  public Developer save(Developer developer) {
    try {
      return DeveloperRepository.save(developer);
    } catch (Exception e) {
      throw new RuntimeException("failure to save Developer.");
    }
  }

  public Developer update(Developer developer) {
    Optional<Developer> obj = findById(developer.getId());

    try {
      developer.setId(obj.get().getId());
      return DeveloperRepository.save(developer);
    } catch (Exception e) {
      throw new RuntimeException("failure to update Developer.");
    }
  }

  public void delete(UUID id) {
    Optional<Developer> obj = findById(id);

    try {
      DeveloperRepository.delete(obj.get());
    } catch (Exception e) {
      throw new RuntimeException("failure to delete Developer.");
    }
  }

  public void progressCourse() {
    Optional<Course> courseOfDeveloper = this.Developer.getEnrolledCourses().stream().findFirst();

    if (courseOfDeveloper.isPresent()) {
      this.Developer.getConcurrentCourses().add(courseOfDeveloper.get());
      this.Developer.getEnrolledCourses().remove(courseOfDeveloper.get());
    } else {
      throw new RuntimeException("This developer is not enrolled in any course.");
    }
  }

  public void progressMentorship() {
    Optional<Mentorship> mentorshipOfDeveloper = this.Developer.getEnrolledMentorships().stream().findFirst();

    if (mentorshipOfDeveloper.isPresent()) {
      this.Developer.getConcurrentMentorships().add(mentorshipOfDeveloper.get());
      this.Developer.getEnrolledMentorships().remove(mentorshipOfDeveloper.get());
    } else {
      throw new RuntimeException("This developer is not enrolled in any mentorship.");
    }
  }
}
