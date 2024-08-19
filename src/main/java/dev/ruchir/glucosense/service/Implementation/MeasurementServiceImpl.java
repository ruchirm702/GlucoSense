package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.MeasurementNotFoundException;
import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.ResourceNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.MeasurementDTO;
import dev.ruchir.glucosense.dto.Core_Dto.PatientDTO;
import dev.ruchir.glucosense.dto.Enum_dto.MeasurementTypeDTO;
import dev.ruchir.glucosense.model.Core.Patient;
import dev.ruchir.glucosense.model.Core.Measurement;
import dev.ruchir.glucosense.model.Enum.MeasurementType;
import dev.ruchir.glucosense.repository.MeasurementRepository;
import dev.ruchir.glucosense.repository.PatientRepository;
import dev.ruchir.glucosense.service.Interface.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final PatientRepository patientRepository;

    @Override
    public MeasurementDTO createMeasurement(MeasurementDTO measurementDTO) {
        Patient patient = findPatientById(measurementDTO.getPatient().getId());
        Measurement measurement = mapToEntity(measurementDTO, patient);
        Measurement savedMeasurement = measurementRepository.save(measurement);
        return mapToDTO(savedMeasurement);
    }

    @Override
    public MeasurementDTO updateMeasurement(Long id, MeasurementDTO measurementDTO) {
        Measurement measurement = findMeasurementById(id);
        Patient patient = findPatientById(measurementDTO.getPatient().getId());
        measurement.setMeasurementDate(measurementDTO.getMeasurementDate());
        measurement.setValue(measurementDTO.getValue());
        measurement.setMeasurementType(MeasurementType.valueOf(measurementDTO.getMeasurementType().name()));
        measurement.setPatient(patient);
        Measurement updatedMeasurement = measurementRepository.save(measurement);
        return mapToDTO(updatedMeasurement);
    }

    @Override
    public MeasurementDTO getMeasurementById(Long id) {
        Measurement measurement = findMeasurementById(id);
        return mapToDTO(measurement);
    }

    @Override
    public List<MeasurementDTO> getAllMeasurements() {
        List<Measurement> measurements = measurementRepository.findAll();
        return measurements.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MeasurementDTO> getMeasurementsByPatientId(Long patientId) {
        List<Measurement> measurements = measurementRepository.findByPatientId(patientId);
        return measurements.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMeasurement(Long id) {
        Measurement measurement = findMeasurementById(id);
        measurementRepository.delete(measurement);
    }

    private Measurement mapToEntity(MeasurementDTO measurementDTO, Patient patient) {
        Measurement measurement = new Measurement();
        measurement.setMeasurementDate(measurementDTO.getMeasurementDate());
        measurement.setValue(measurementDTO.getValue());
        measurement.setMeasurementType(MeasurementType.valueOf(measurementDTO.getMeasurementType().name()));
        measurement.setPatient(patient);
        return measurement;
    }

    private MeasurementDTO mapToDTO(Measurement measurement) {
        MeasurementDTO dto = new MeasurementDTO();
        dto.setId(measurement.getId());
        dto.setMeasurementDate(measurement.getMeasurementDate());
        dto.setValue(measurement.getValue());
        dto.setMeasurementType(new MeasurementTypeDTO(measurement.getMeasurementType().name()));
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(measurement.getPatient().getId());
        dto.setPatient(patientDTO);
        return dto;
    }

    private Measurement findMeasurementById(Long id) {
        return measurementRepository.findById(id)
                .orElseThrow(() -> new MeasurementNotFoundException("Measurement not found with ID: " + id));
    }

    private Patient findPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + id));
    }
}
