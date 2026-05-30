package org.example.hospital_management_system.requestDTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.example.hospital_management_system.Enums.PaymentStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillRequestDTO {
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private long appointmentId;
    private long patientId;
    private long amount;


}
