package org.example.hospital_management_system.services;

import org.example.hospital_management_system.models.Appointments;
import org.example.hospital_management_system.models.Bill;
import org.example.hospital_management_system.models.Patients;
import org.example.hospital_management_system.repositories.AppointmentRepository;
import org.example.hospital_management_system.repositories.BillRepository;
import org.example.hospital_management_system.repositories.PatientRepository;
import org.example.hospital_management_system.requestDTO.BillRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    final private  BillRepository billRepository;
    final private AppointmentRepository appointmentRepository;
    final private PatientRepository patientRepository;

    public BillService(BillRepository billRepository, AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.billRepository = billRepository;
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }
    public ResponseEntity<?> addBill(BillRequestDTO bill){
        Bill billEntity = new Bill();
        billEntity.setAmount(bill.getAmount());
        Patients patient=patientRepository.findById(bill.getPatientId()).orElseThrow(()-> new RuntimeException("Patient Not Found"));
        Appointments appointments= appointmentRepository.findById(bill.getAppointmentId()).orElseThrow(()-> new RuntimeException("Appointment Not Found"));
        billEntity.setPatients(patient);
        billEntity.setAppointment(appointments);
        billRepository.save(billEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(billEntity);
    }
    public ResponseEntity<?> deleteBill(Long id){
        billRepository.deleteById(id);
        return ResponseEntity.ok("Bill deleted successfully");

    }
    public ResponseEntity<?> updateBill(long id,BillRequestDTO bill){
        Bill billEntity = billRepository.findById(id).orElseThrow(()-> new RuntimeException("Bill Not Found"));
        billEntity.setAmount(bill.getAmount());
        billRepository.save(billEntity);
        return ResponseEntity.ok("Bill updated successfully");
    }
    public ResponseEntity<?> getBillById(Long id){
        return ResponseEntity.ok(billRepository.findById(id).orElseThrow(()-> new RuntimeException("Bill Not Found")));
    }
    public ResponseEntity<List<?>> getAllBill(){
        return ResponseEntity.ok(billRepository.findAll());
    }
}
