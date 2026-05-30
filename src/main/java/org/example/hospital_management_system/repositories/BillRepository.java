package org.example.hospital_management_system.repositories;

import org.example.hospital_management_system.models.Appointments;
import org.example.hospital_management_system.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository  extends JpaRepository<Bill, Long> {
}
