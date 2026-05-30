package org.example.hospital_management_system.services;


import org.example.hospital_management_system.models.Appointments;
import org.example.hospital_management_system.models.Doctors;
import org.example.hospital_management_system.models.Patients;
import org.example.hospital_management_system.repositories.AppointmentRepository;
import org.example.hospital_management_system.repositories.DoctorRepository;
import org.example.hospital_management_system.repositories.PatientRepository;
import org.example.hospital_management_system.requestDTO.AppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    public ResponseEntity<?> addAppointment(AppointmentDTO appointment){

        long patient_id=appointment.getPatientId();
        long doctor_id=appointment.getDoctorId();
        Doctors doctors=doctorRepository.findById(doctor_id).orElseThrow(()->new RuntimeException("doctor not found"));
        Patients patients=patientRepository.findById(patient_id).orElseThrow(()->new RuntimeException("patient not found"));
        Appointments appointments= new Appointments();
        appointments.setAppointmentDate(new Date());
        appointments.setDoctor(doctors);
        appointments.setPatient(patients);
        appointmentRepository.save(appointments);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
    }
    public ResponseEntity<?> deleteAppointment(Long id){
        Appointments appointment= appointmentRepository.findById(id).orElseThrow(()->new RuntimeException("appointment not found"));
        appointmentRepository.delete(appointment);
        return ResponseEntity.status(HttpStatus.OK).body(appointment);
    }

}
