package com.dio.bootcamp.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity(name = "tb_course")
@Data
public class Course {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "VARCHAR(255)")
  private UUID id;

  private String title;

  private String description;

  private int workload;

  @ManyToMany
  private Set<Developer> likes;
}
