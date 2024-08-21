package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.model.Core.Insurance;
import java.time.LocalDate;
import java.util.List;

public interface InsuranceService {

    Insurance createInsurance(Insurance insurance);

    Insurance updateInsurance(Long id, Insurance insurance);

    Insurance getInsuranceById(Long id);

    void deleteInsurance(Long id);

    List<Insurance> getAllInsurance();

    List<Insurance> getInsuranceByPatientId(Long patientId);

    Insurance getInsuranceByPolicyNumber(String policyNumber);

    List<Insurance> getInsuranceByProviderName(String providerName);

    List<Insurance> getInsuranceByExpiryDateBefore(LocalDate date);

    List<Insurance> getInsuranceByExpiryDateAfter(LocalDate date);

    long countInsuranceByProviderName(String providerName);
}
