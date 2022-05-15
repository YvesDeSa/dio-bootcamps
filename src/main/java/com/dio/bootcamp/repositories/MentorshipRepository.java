package com.dio.bootcamp.repositories;

import java.util.Optional;
import java.util.UUID;

import com.dio.bootcamp.model.Mentorship;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MentorshipRepository extends JpaRepository<Mentorship, UUID> {
  public Optional<Mentorship> findById(UUID id);
}
