package org.example.hospital_management_system.controllers;
import org.example.hospital_management_system.models.Doctors;
import org.example.hospital_management_system.services.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorsController {
    final private DoctorService doctorService;
    public DoctorsController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @GetMapping
    public ResponseEntity<List<Doctors>> findAllDoctors() {
        return ResponseEntity.ok(doctorService.findAllDoctors());
    }
    @PostMapping
    public  ResponseEntity<Doctors> save(@RequestBody Doctors doctors) {
        System.out.println("Saving patient " + doctors);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.saveDoctor(doctors));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        System.out.println("Fetching patient " + id);
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable long id, @RequestBody Doctors doctors) {
        System.out.println("Updating patient " + id);
        return doctorService.updateDoctor(id,doctors);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteDoctor(@PathVariable long id) {
        System.out.println("Deleting patient " + id);
        return doctorService.deleteDoctorById(id);
    }
}
