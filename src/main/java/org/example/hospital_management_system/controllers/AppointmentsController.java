package org.example.hospital_management_system.controllers;

import jdk.jfr.Enabled;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentsController {

    @PostMapping("/appointment")
    public <T> ResponseEntity<T> createAppointment(@RequestBody T appointment){
        return (ResponseEntity<T>) ResponseEntity.ok(appointment);
    }
    @GetMapping("/all")
    public <T> ResponseEntity<T> getAppointments(){
        return null;
    }
    @GetMapping("/all/{id}")
    public <T> ResponseEntity<T> getAppointment(@PathVariable Long id){
        return null;
    }
    @PutMapping("/all/{id}")
    public <T> ResponseEntity<T> updateAppointment(@PathVariable Long id){
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public <T> ResponseEntity<T> deleteAppointment(@PathVariable Long id){
        return null;
    }
}
