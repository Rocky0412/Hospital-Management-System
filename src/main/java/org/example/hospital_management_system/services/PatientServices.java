package org.example.hospital_management_system.services;


import org.example.hospital_management_system.models.Patients;
import org.example.hospital_management_system.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PatientServices {

   private final PatientRepository patientRepository;
   PatientServices(PatientRepository patientRepository) {
       this.patientRepository = patientRepository;
   }
   public List<Patients> getPatients(){
        try {
            System.out.println("Fetching patient list");
            return patientRepository.findAll();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }

    }
    public Patients getPatientById(long id){
        try {
            System.out.println("Fetching patient " + id);
            return patientRepository.findById(id).orElse(null);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Patients updatePatient(Long id,Patients patient){
      Patients p = patientRepository.findById(id).orElse(null);
      if(p==null){
          return null;
      }

      p.setName(patient.getName());
      p.setSurname(patient.getSurname());
      p.setEmail(patient.getEmail());
      return patientRepository.save(p);
    }
    public Patients addPatient(Patients patient){

       return patientRepository.save(patient);
    }
    public void deletePatient(Long id){
        System.out.println("Deleting patient " + id);
       patientRepository.deleteById(id);

    }
}
