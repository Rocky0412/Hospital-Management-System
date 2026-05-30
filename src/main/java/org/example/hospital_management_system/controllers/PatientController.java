package org.example.hospital_management_system.controllers;
import org.example.hospital_management_system.models.Appointments;
import org.example.hospital_management_system.models.Patients;
import org.example.hospital_management_system.repositories.PatientRepository;
import org.example.hospital_management_system.services.PatientServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    final private PatientServices patientServices;
    PatientController(PatientServices patientServices){
        this.patientServices = patientServices;

    }
    @GetMapping
    public <T> ResponseEntity<List<T>> findAllPatients() {
        System.out.println("Fetching all patients");
        List<Patients>patients=patientServices.getPatients();
        return ResponseEntity.ok().body((List<T>) patients);
    }
    @PostMapping
    public ResponseEntity<?> createNewPatient(@RequestBody Patients patient) {
        System.out.println("Saving patient " + patient);
        patientServices.addPatient((Patients) patient);

        return ResponseEntity.ok().body(patient);
    }
    @GetMapping("/{id}")
    public <T> Patients findById(@PathVariable long id) {
        System.out.println("Fetching patient " + id);
        return patientServices.getPatientById(id);

    }
    @PutMapping("/{id}")
    public <T> ResponseEntity<T> update(@PathVariable long id, @RequestBody Patients patient) {
        System.out.println("Updating patient " + id);
        patientServices.updatePatient(id, patient);
        return (ResponseEntity<T>) ResponseEntity.ok(patient);
    }
    @DeleteMapping("/{id}")
    public <T> ResponseEntity<?> delete(@PathVariable long id) {
        System.out.println("Deleting patient " + id);
        patientServices.deletePatient(id);
        return (ResponseEntity<?>) ResponseEntity.ok(id);
    }
    @GetMapping("/appointment/{id}")
    public ResponseEntity<List<Appointments>> findAllAppointment(@PathVariable long id) {
      return ResponseEntity.ok(patientServices.getAppointmentsByPatientId(id));

    }

}
