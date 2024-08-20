package dev.ruchir.glucosense.dto.Core_Dto;

import dev.ruchir.glucosense.model.Enum.BillingType;
import dev.ruchir.glucosense.model.Enum.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillingDTO {
    private Long id;
    private Long patientId;
    private Long consultationId;
    private double amount;
    private BillingType billingType;
    private LocalDate billingDate;
    private PaymentStatus status;
}
