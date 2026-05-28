package org.example.hospital_management_system.models;


import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String name;
    private String surname;
    @Column(length = 100,nullable = false)
    private String email;
}
