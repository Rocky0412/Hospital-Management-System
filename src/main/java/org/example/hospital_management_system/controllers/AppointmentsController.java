package org.example.hospital_management_system.controllers;

import jdk.jfr.Enabled;
import org.example.hospital_management_system.models.Appointments;
import org.example.hospital_management_system.models.Doctors;
import org.example.hospital_management_system.models.Patients;
import org.example.hospital_management_system.repositories.AppointmentRepository;
import org.example.hospital_management_system.repositories.DoctorRepository;
import org.example.hospital_management_system.repositories.PatientRepository;
import org.example.hospital_management_system.requestDTO.AppointmentDTO;
import org.example.hospital_management_system.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentsController {

    final private PatientRepository patientRepository;
    final private DoctorRepository doctorRepository;
    final private AppointmentRepository appointmentRepository;
    final private AppointmentService appointmentService;
    public AppointmentsController(PatientRepository patientRepository, DoctorRepository doctorRepository,
                                  AppointmentRepository appointmentRepository, AppointmentService appointmentService)
    {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.appointmentService=appointmentService;
    }

    @PostMapping
    public  ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointment){
        return appointmentService.addAppointment(appointment);
    }
    @GetMapping
    public  ResponseEntity<List<?>> getAppointments(){
        return ResponseEntity.ok(appointmentRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAppointment(@PathVariable Long id){
        Appointments appointments=appointmentRepository.findById(id).orElseThrow(()->new RuntimeException("appointment not found"));
        return ResponseEntity.ok(appointments);
    }
    @PutMapping("/update/{id}")
    public  ResponseEntity<?> updateAppointment(@PathVariable Long id,@RequestBody AppointmentDTO appointmentDTO){
        Appointments appointment=appointmentRepository.findById(id).orElseThrow(()->new RuntimeException("appointment not found"));
        appointment.setAppointmentDate(new Date(System.currentTimeMillis() + 5L * 24 * 60 * 60 * 1000));
        appointmentRepository.save(appointment);
        return ResponseEntity.ok("appointment updated successfully {appointment}");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long id){
        return appointmentService.deleteAppointment(id);
    }
}
