package org.example.hospital_management_system.services;

import org.example.hospital_management_system.models.Doctors;
import org.example.hospital_management_system.repositories.DoctorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    final private DoctorRepository doctorRepository;
    DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    public List<Doctors> findAllDoctors() {
        return doctorRepository.findAll();
    }
    public Doctors saveDoctor(Doctors doctors) {
        return doctorRepository.save(doctors);
    }
    public Doctors getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }
    public ResponseEntity<Object> updateDoctor(Long id, Doctors doctors) {
        Doctors doctor=doctorRepository.findById(id).orElse(null);
        if(doctor==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        doctor.setName(doctors.getName());
        doctor.setSpecialty(doctors.getSpecialty());
        doctorRepository.save(doctor);
        return ResponseEntity.ok(doctor);
    }
    public ResponseEntity<?> deleteDoctorById(Long id) {
        Doctors doctor=doctorRepository.findById(id).orElse(null);
        if(doctor==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        doctorRepository.delete(doctor);
        return ResponseEntity.ok().build();
    }


}
