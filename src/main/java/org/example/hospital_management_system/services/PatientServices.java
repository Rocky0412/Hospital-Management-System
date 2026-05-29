package org.example.hospital_management_system.services;


import org.example.hospital_management_system.models.Patients;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServices {
   public List<Patients> getPatients(){
        try {
            System.out.println("Fetching patient list");
            return  null;
        }
        catch (Exception e){
            return null;
        }

    }
    public Patients getPatientById(long id){
        try {
            System.out.println("Fetching patient " + id);
            return null;
        }
        catch (Exception e){
            return null;
        }
    }
    public Patients updatePatient(Long id,Patients patient){
        try {
            System.out.println("Updating patient " + id);
            return null;
        }
        catch (Exception e){
            return null;
        }
    }
    public Patients addPatient(Patients patient){
        try {
            System.out.println("Adding patient " + patient);
            return null;
        }
        catch (Exception e){
            return null;
        }
    }
    public Patients deletePatient(Long id){
        try {
            System.out.println("Deleting patient " + id);
            return null;
        }
        catch (Exception e){
            return null;
        }
    }
}
