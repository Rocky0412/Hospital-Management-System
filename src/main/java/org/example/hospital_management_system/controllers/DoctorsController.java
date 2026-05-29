package org.example.hospital_management_system.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorsController {
    @GetMapping("/")
    public <T> ResponseEntity<List<T>> findAll() {
        System.out.println("Fetching all patients");
        return ResponseEntity.ok().body(new ArrayList<>());
    }
    @PostMapping
    public <T> ResponseEntity<T> save(@RequestBody T patient) {
        System.out.println("Saving patient " + patient);
        return ResponseEntity.ok().body(patient);
    }
    @GetMapping("/{id}")
    public <T> ResponseEntity<T> findById(@PathVariable long id) {
        System.out.println("Fetching patient " + id);
        return null;
    }
    @PutMapping("/{id}")
    public <T> ResponseEntity<T> update(@PathVariable long id, @RequestBody T patient) {
        System.out.println("Updating patient " + id);
        return (ResponseEntity<T>) ResponseEntity.ok(patient);
    }
    @DeleteMapping("/{id}")
    public <T> ResponseEntity<?> delete(@PathVariable long id) {
        System.out.println("Deleting patient " + id);
        return (ResponseEntity<?>) ResponseEntity.ok(id);
    }
}
