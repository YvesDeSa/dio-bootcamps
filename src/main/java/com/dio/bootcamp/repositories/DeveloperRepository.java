package com.dio.bootcamp.repositories;

import java.util.Optional;
import java.util.UUID;

import com.dio.bootcamp.model.Developer;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, UUID> {

  public Optional<Developer> findById(UUID id);

}