package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.Billing;
import dev.ruchir.glucosense.model.Enum.BillingType;
import dev.ruchir.glucosense.model.Enum.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BillingRepository extends JpaRepository<Billing, Long> {

    List<Billing> findByPatientId(Long patientId);

    List<Billing> findByConsultationId(Long consultationId);

    List<Billing> findByBillingType(BillingType billingType);

    List<Billing> findByStatus(PaymentStatus status);

    List<Billing> findByBillingDateBetween(LocalDate startDate, LocalDate endDate);

    long countByPatientId(Long patientId);

    long countByConsultationId(Long consultationId);

    Optional<Billing> findTopByPatientIdOrderByBillingDateDesc(Long patientId);

    List<Billing> findByAmountGreaterThan(double amount);
}
