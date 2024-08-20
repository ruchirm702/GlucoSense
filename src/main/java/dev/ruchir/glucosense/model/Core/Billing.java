package dev.ruchir.glucosense.model.Core;

import dev.ruchir.glucosense.model.Enum.BillingType;
import dev.ruchir.glucosense.model.Enum.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Consultation consultation;

    private double amount;

    @Enumerated(EnumType.STRING)
    private BillingType billingType;

    private LocalDate billingDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
}
