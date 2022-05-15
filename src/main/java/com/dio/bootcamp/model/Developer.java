package com.dio.bootcamp.model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity(name = "tb_developer")
@Data
public class Developer {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "VARCHAR(255)")
  private UUID id;

  private String name;

  @ManyToMany
  private Set<Course> enrolledCourses = new LinkedHashSet<Course>();

  @ManyToMany
  private Set<Course> concurrentCourses = new LinkedHashSet<Course>();

  @ManyToMany
  private Set<Mentorship> enrolledMentorships = new LinkedHashSet<Mentorship>();

  @ManyToMany
  private Set<Mentorship> concurrentMentorships = new LinkedHashSet<Mentorship>();
}
