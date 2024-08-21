package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.InsuranceNotFoundException;
import dev.ruchir.glucosense.model.Core.Insurance;
import dev.ruchir.glucosense.repository.InsuranceRepository;
import dev.ruchir.glucosense.service.Interface.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceServiceImpl(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public Insurance createInsurance(Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

    @Override
    public Insurance updateInsurance(Long id, Insurance insurance) {
        if (!insuranceRepository.existsById(id)) {
            throw new InsuranceNotFoundException("Insurance not found with ID: " + id);
        }
        insurance.setId(id); // Ensure the ID is set for the update
        return insuranceRepository.save(insurance);
    }

    @Override
    public Insurance getInsuranceById(Long id) {
        return insuranceRepository.findById(id)
                .orElseThrow(() -> new InsuranceNotFoundException("Insurance not found with ID: " + id));
    }

    @Override
    public void deleteInsurance(Long id) {
        if (!insuranceRepository.existsById(id)) {
            throw new InsuranceNotFoundException("Insurance not found with ID: " + id);
        }
        insuranceRepository.deleteById(id);
    }

    @Override
    public List<Insurance> getAllInsurance() {
        return insuranceRepository.findAll();
    }

    @Override
    public List<Insurance> getInsuranceByPatientId(Long patientId) {
        return insuranceRepository.findByPatientId(patientId);
    }

    @Override
    public Insurance getInsuranceByPolicyNumber(String policyNumber) {
        return insuranceRepository.findByPolicyNumber(policyNumber);
    }

    @Override
    public List<Insurance> getInsuranceByProviderName(String providerName) {
        return insuranceRepository.findByProviderName(providerName);
    }

    @Override
    public List<Insurance> getInsuranceByExpiryDateBefore(LocalDate date) {
        return insuranceRepository.findByExpiryDateBefore(date);
    }

    @Override
    public List<Insurance> getInsuranceByExpiryDateAfter(LocalDate date) {
        return insuranceRepository.findByExpiryDateAfter(date);
    }

    @Override
    public long countInsuranceByProviderName(String providerName) {
        return insuranceRepository.countByProviderName(providerName);
    }
}
