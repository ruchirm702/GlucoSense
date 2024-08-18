package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.BloodSugarRecordNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.BloodSugarRecordDTO;
import dev.ruchir.glucosense.dto.Core_Dto.PatientDTO;
import dev.ruchir.glucosense.model.Core.BloodSugarRecord;
import dev.ruchir.glucosense.model.Core.Patient;
import dev.ruchir.glucosense.model.Enum.MeasurementType;
import dev.ruchir.glucosense.repository.BloodSugarRecordRepository;
import dev.ruchir.glucosense.repository.PatientRepository;
import dev.ruchir.glucosense.service.Interface.BloodSugarRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BloodSugarRecordServiceImpl implements BloodSugarRecordService {

    private final BloodSugarRecordRepository bloodSugarRecordRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public BloodSugarRecordServiceImpl(BloodSugarRecordRepository bloodSugarRecordRepository, PatientRepository patientRepository) {
        this.bloodSugarRecordRepository = bloodSugarRecordRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public BloodSugarRecordDTO createBloodSugarRecord(BloodSugarRecordDTO bloodSugarRecordDTO) {
        // Fetch the Patient entity from the repository
        Patient patient = patientRepository.findById(bloodSugarRecordDTO.getPatient().getId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + bloodSugarRecordDTO.getPatient().getId()));

        BloodSugarRecord bloodSugarRecord = new BloodSugarRecord();
        bloodSugarRecord.setPatient(patient);
        bloodSugarRecord.setRecordDate(bloodSugarRecordDTO.getTimestamp());
        bloodSugarRecord.setGlucoseLevel(bloodSugarRecordDTO.getLevel());
        bloodSugarRecord.setMeasurementType(MeasurementType.BLOOD_SUGAR);

        BloodSugarRecord savedRecord = bloodSugarRecordRepository.save(bloodSugarRecord);
        return mapToDTO(savedRecord);
    }

    @Override
    public BloodSugarRecordDTO getBloodSugarRecordById(Long id) {
        BloodSugarRecord bloodSugarRecord = bloodSugarRecordRepository.findById(id)
                .orElseThrow(() -> new BloodSugarRecordNotFoundException("Blood sugar record not found with id: " + id));
        return mapToDTO(bloodSugarRecord);
    }

    @Override
    public List<BloodSugarRecordDTO> getAllBloodSugarRecords() {
        return bloodSugarRecordRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BloodSugarRecordDTO> getBloodSugarRecordsByPatientId(Long patientId) {
        return bloodSugarRecordRepository.findByPatientId(patientId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BloodSugarRecordDTO> getBloodSugarRecordsBetweenDates(LocalDateTime start, LocalDateTime end) {
        return bloodSugarRecordRepository.findByRecordDateBetween(start, end).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BloodSugarRecordDTO updateBloodSugarRecord(Long id, BloodSugarRecordDTO bloodSugarRecordDTO) {
        BloodSugarRecord existingRecord = bloodSugarRecordRepository.findById(id)
                .orElseThrow(() -> new BloodSugarRecordNotFoundException("Blood sugar record not found with id: " + id));

        // Fetch the Patient entity from the repository
        Patient patient = patientRepository.findById(bloodSugarRecordDTO.getPatient().getId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + bloodSugarRecordDTO.getPatient().getId()));

        existingRecord.setPatient(patient);
        existingRecord.setRecordDate(bloodSugarRecordDTO.getTimestamp());
        existingRecord.setGlucoseLevel(bloodSugarRecordDTO.getLevel());

        BloodSugarRecord updatedRecord = bloodSugarRecordRepository.save(existingRecord);
        return mapToDTO(updatedRecord);
    }

    @Override
    public void deleteBloodSugarRecord(Long id) {
        BloodSugarRecord bloodSugarRecord = bloodSugarRecordRepository.findById(id)
                .orElseThrow(() -> new BloodSugarRecordNotFoundException("Blood sugar record not found with id: " + id));
        bloodSugarRecordRepository.delete(bloodSugarRecord);
    }

    private BloodSugarRecordDTO mapToDTO(BloodSugarRecord bloodSugarRecord) {
        BloodSugarRecordDTO dto = new BloodSugarRecordDTO();
        dto.setId(bloodSugarRecord.getId());
        dto.setPatient(mapToPatientDTO(bloodSugarRecord.getPatient())); // Assuming you need to convert Patient to PatientDTO
        dto.setTimestamp(bloodSugarRecord.getRecordDate());
        dto.setLevel(bloodSugarRecord.getGlucoseLevel());
        return dto;
    }

    private PatientDTO mapToPatientDTO(Patient patient) {
        // Implement the conversion logic from Patient to PatientDTO
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        // Set other fields as needed
        return patientDTO;
    }
}
