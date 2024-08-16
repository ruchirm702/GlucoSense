package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.ResourceNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.PatientDTO;
import dev.ruchir.glucosense.model.Core.Patient;
import dev.ruchir.glucosense.model.Enum.BloodType;
import dev.ruchir.glucosense.repository.PatientRepository;
import dev.ruchir.glucosense.service.Interface.PatientService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;
public class PatientServiceIMPL implements PatientService {
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    // Constructor Injection
    public PatientServiceIMPL(PatientRepository patientRepository, ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(patient -> modelMapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientDTO> getPatientsByName(String username) {
        return patientRepository.findByUsername(username)
                .stream()
                .map(patient -> modelMapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        return modelMapper.map(patient, PatientDTO.class);
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        patient = patientRepository.save(patient);
        return modelMapper.map(patient, PatientDTO.class);
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        patientRepository.delete(patient);
    }

    @Override
    public Long countPatientsByBloodType(BloodType bloodType) {
        return patientRepository.countByBloodType(bloodType);
    }
}
