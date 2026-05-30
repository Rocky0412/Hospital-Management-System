package org.example.hospital_management_system.controllers;


import org.example.hospital_management_system.models.Appointments;
import org.example.hospital_management_system.models.Bill;
import org.example.hospital_management_system.models.Patients;
import org.example.hospital_management_system.repositories.AppointmentRepository;
import org.example.hospital_management_system.repositories.BillRepository;
import org.example.hospital_management_system.repositories.DoctorRepository;
import org.example.hospital_management_system.repositories.PatientRepository;
import org.example.hospital_management_system.requestDTO.BillRequestDTO;
import org.example.hospital_management_system.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {

    final private BillService billService;
    public BillController(BillService billService) {
        this.billService = billService;
    }
    @PostMapping
    public ResponseEntity<?> addCreate(@RequestBody BillRequestDTO bill){
        return billService.addBill(bill);
    }
    @GetMapping
    public  ResponseEntity<List<?>> findAllBill(){
        return billService.getAllBill();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findBillById(@PathVariable Long id){
        return billService.getBillById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBill(@PathVariable Long id, @RequestBody BillRequestDTO bill){
        return billService.updateBill(id,bill);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBill(@PathVariable Long id){
        return billService.deleteBill(id);
    }
}
