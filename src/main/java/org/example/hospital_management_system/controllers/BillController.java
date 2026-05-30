package org.example.hospital_management_system.controllers;


import org.example.hospital_management_system.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {

    final private  BillRepository billRepository;

    public BillController(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @PostMapping
    public <T> ResponseEntity<T> addCreate(@RequestBody T bill){
        return null;
    }
    @GetMapping
    public <T> ResponseEntity<List<T>> findAllBill(){
        return null;
    }
    @GetMapping("/{id}")
    public <T> ResponseEntity<T> findBillById(@PathVariable Long id){
        return null;
    }
    @PutMapping("/{id}")
    public <T> ResponseEntity<T> updateBill(@PathVariable Long id, @RequestBody T bill){
        return null;
    }
    @DeleteMapping("/{id}")
    public <T> ResponseEntity<T> deleteBill(@PathVariable Long id){
        return null;
    }
}
