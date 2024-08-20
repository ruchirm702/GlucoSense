package dev.ruchir.glucosense.dto.Core_Dto;

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
public class PaymentDTO {
    private Long id;
    private Long billingId;
    private double amountPaid;
    private LocalDate paymentDate;
    private PaymentStatus paymentStatus;
    private String paymentMethod;
}
