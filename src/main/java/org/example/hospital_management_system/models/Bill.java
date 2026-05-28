package org.example.hospital_management_system.models;

import jakarta.persistence.*;
import lombok.*;
import org.example.hospital_management_system.Enums.PaymentStatus;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long patientId;
    private long amount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
