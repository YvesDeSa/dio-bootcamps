package com.dio.bootcamp.service;

import com.dio.bootcamp.repositories.MentorshipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dio.bootcamp.model.Mentorship;

@Service
public class MentorshipService {

  @Autowired
  private MentorshipRepository MentorshipRepository;

  private static final double XP_DEFAULT = 10d;

  public List<Mentorship> findAll() {
    return (List<Mentorship>) MentorshipRepository.findAll();
  }

  public Optional<Mentorship> findById(UUID id) {
    Optional<Mentorship> result = MentorshipRepository.findById(id);

    if (result.isEmpty()) {
      throw new RuntimeException("Mentorship not found");
    }

    return result;
  }

  public Mentorship save(Mentorship mentorship) {
    try {
      return MentorshipRepository.save(mentorship);
    } catch (Exception e) {
      throw new RuntimeException("failure to save Mentorship.");
    }
  }

  public Mentorship update(Mentorship mentorship) {
    Optional<Mentorship> obj = findById(mentorship.getId());

    try {
      mentorship.setId(obj.get().getId());
      return MentorshipRepository.save(mentorship);
    } catch (Exception e) {
      throw new RuntimeException("failure to update Mentorship.");
    }
  }

  public void delete(UUID id) {
    Optional<Mentorship> obj = findById(id);

    try {
      MentorshipRepository.delete(obj.get());
    } catch (Exception e) {
      throw new RuntimeException("failure to delete Mentorship.");
    }
  }

  public double calculateXp() {
    return XP_DEFAULT + 10d;
  }
}
