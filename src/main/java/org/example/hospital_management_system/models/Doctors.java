package org.example.hospital_management_system.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String specialty;
    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    List<Appointments> appointments;

}
