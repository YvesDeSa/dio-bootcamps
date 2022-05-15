package com.dio.bootcamp.controller;

import java.util.UUID;

import com.dio.bootcamp.model.Developer;
import com.dio.bootcamp.service.DeveloperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/apirest/developers")
public class DeveloperController {

  @Autowired
  private DeveloperService service;

  @GetMapping
  public ResponseEntity getAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity getOne(@PathVariable("id") UUID id) {

    return ResponseEntity.ok(service.findById(id));
  }

  @PostMapping
  public ResponseEntity save(@RequestBody Developer developer) {
    developer.setId(null);

    service.save(developer);

    return ResponseEntity.status(HttpStatus.CREATED).body(developer);
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody Developer developer) {
    developer.setId(null);
    service.update(developer);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity delete(@PathVariable("id") UUID id) {
    service.delete(id);
    return ResponseEntity.ok().build();
  }
}
