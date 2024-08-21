package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    List<Insurance> findByPatientId(Long patientId);

    Insurance findByPolicyNumber(String policyNumber);

    List<Insurance> findByProviderName(String providerName);

    List<Insurance> findByExpiryDateBefore(LocalDate date);

    List<Insurance> findByExpiryDateAfter(LocalDate date);

    long countByProviderName(String providerName);
}
