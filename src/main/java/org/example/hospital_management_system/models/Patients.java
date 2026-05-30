package org.example.hospital_management_system.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String surname;
    @Column(length = 100,nullable = false)
    private String email;
    @OneToMany(mappedBy = "patients")
    private List<Bill> billing;
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    List<Appointments> appointments;

}
