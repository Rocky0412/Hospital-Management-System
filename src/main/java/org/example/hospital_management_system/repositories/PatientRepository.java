package org.example.hospital_management_system.repositories;

import org.example.hospital_management_system.models.Doctors;
import org.example.hospital_management_system.models.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patients, Long> {
}
