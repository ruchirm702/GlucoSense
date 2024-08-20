package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.Payment;
import dev.ruchir.glucosense.model.Enum.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByBillingId(Long billingId);

    List<Payment> findByPaymentStatus(PaymentStatus paymentStatus);

    List<Payment> findByPaymentDateBetween(LocalDate startDate, LocalDate endDate);

    Optional<Payment> findTopByBillingIdOrderByPaymentDateDesc(Long billingId);

    List<Payment> findByAmountPaidGreaterThan(double amount);
}
