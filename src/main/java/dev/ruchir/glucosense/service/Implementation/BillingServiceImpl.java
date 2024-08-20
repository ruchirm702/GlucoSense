package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.BillingNotFoundException;
import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.InvalidBillingDataException;
import dev.ruchir.glucosense.dto.Core_Dto.BillingDTO;
import dev.ruchir.glucosense.model.Core.Billing;
import dev.ruchir.glucosense.model.Core.Consultation;
import dev.ruchir.glucosense.model.Core.Patient;
import dev.ruchir.glucosense.repository.BillingRepository;
import dev.ruchir.glucosense.repository.ConsultationRepository;
import dev.ruchir.glucosense.repository.PatientRepository;
import dev.ruchir.glucosense.service.Interface.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;
    private final PatientRepository patientRepository;
    private final ConsultationRepository consultationRepository;

    @Autowired
    public BillingServiceImpl(BillingRepository billingRepository, PatientRepository patientRepository, ConsultationRepository consultationRepository) {
        this.billingRepository = billingRepository;
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public BillingDTO createBilling(BillingDTO billingDTO) {
        Patient patient = patientRepository.findById(billingDTO.getPatientId())
                .orElseThrow(() -> new InvalidBillingDataException("Patient not found"));
        Consultation consultation = consultationRepository.findById(billingDTO.getConsultationId())
                .orElseThrow(() -> new InvalidBillingDataException("Consultation not found"));

        Billing billing = new Billing();
        billing.setPatient(patient);
        billing.setConsultation(consultation);
        billing.setAmount(billingDTO.getAmount());
        billing.setBillingType(billingDTO.getBillingType());
        billing.setBillingDate(billingDTO.getBillingDate());
        billing.setStatus(billingDTO.getStatus());

        billing = billingRepository.save(billing);
        return mapToDTO(billing);
    }

    @Override
    public BillingDTO getBillingById(Long id) {
        Billing billing = billingRepository.findById(id)
                .orElseThrow(() -> new BillingNotFoundException("Billing record not found"));
        return mapToDTO(billing);
    }

    @Override
    public List<BillingDTO> getAllBillings() {
        return billingRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BillingDTO updateBilling(Long id, BillingDTO billingDTO) {
        Billing billing = billingRepository.findById(id)
                .orElseThrow(() -> new BillingNotFoundException("Billing record not found"));

        billing.setAmount(billingDTO.getAmount());
        billing.setBillingType(billingDTO.getBillingType());
        billing.setBillingDate(billingDTO.getBillingDate());
        billing.setStatus(billingDTO.getStatus());

        billing = billingRepository.save(billing);
        return mapToDTO(billing);
    }

    @Override
    public void deleteBilling(Long id) {
        Billing billing = billingRepository.findById(id)
                .orElseThrow(() -> new BillingNotFoundException("Billing record not found"));
        billingRepository.delete(billing);
    }

    private BillingDTO mapToDTO(Billing billing) {
        return new BillingDTO(
                billing.getId(),
                billing.getPatient().getId(),
                billing.getConsultation().getId(),
                billing.getAmount(),
                billing.getBillingType(),
                billing.getBillingDate(),
                billing.getStatus()
        );
    }
}
