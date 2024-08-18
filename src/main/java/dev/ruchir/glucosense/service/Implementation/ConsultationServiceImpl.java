package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.ConsultationNotFoundException;
import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.InvalidConsultationDataException;
import dev.ruchir.glucosense.dto.Core_Dto.ConsultationDTO;
import dev.ruchir.glucosense.dto.Core_Dto.DoctorDTO;
import dev.ruchir.glucosense.dto.Core_Dto.PatientDTO;
import dev.ruchir.glucosense.model.Core.Consultation;
import dev.ruchir.glucosense.model.Core.Doctor;
import dev.ruchir.glucosense.model.Core.Patient;
import dev.ruchir.glucosense.repository.ConsultationRepository;
import dev.ruchir.glucosense.repository.DoctorRepository;
import dev.ruchir.glucosense.repository.PatientRepository;
import dev.ruchir.glucosense.service.Interface.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public ConsultationServiceImpl(ConsultationRepository consultationRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.consultationRepository = consultationRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public ConsultationDTO createConsultation(ConsultationDTO consultationDTO) throws InvalidConsultationDataException {
        validateConsultationData(consultationDTO);

        // Convert DTO to entity
        Consultation consultation = mapToEntity(consultationDTO, new Consultation());

        // Save the entity
        Consultation savedConsultation = consultationRepository.save(consultation);

        // Convert entity to DTO
        return convertToDTO(savedConsultation);
    }

    @Override
    public ConsultationDTO updateConsultation(Long id, ConsultationDTO consultationDTO)
            throws ConsultationNotFoundException, InvalidConsultationDataException {
        // Retrieve existing consultation
        Consultation existingConsultation = consultationRepository.findById(id)
                .orElseThrow(() -> new ConsultationNotFoundException("Consultation not found with ID: " + id));

        validateConsultationData(consultationDTO);

        // Map updated values to the existing entity
        Consultation updatedConsultation = mapToEntity(consultationDTO, existingConsultation);

        // Save the updated entity
        Consultation savedConsultation = consultationRepository.save(updatedConsultation);

        // Convert entity to DTO
        return convertToDTO(savedConsultation);
    }

    @Override
    public ConsultationDTO getConsultationById(Long id) throws ConsultationNotFoundException {
        // Retrieve consultation by ID
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new ConsultationNotFoundException("Consultation not found with ID: " + id));

        // Convert entity to DTO
        return convertToDTO(consultation);
    }

    @Override
    public List<ConsultationDTO> getConsultationsByPatientId(Long patientId) {
        // Retrieve consultations by patient ID
        List<Consultation> consultations = consultationRepository.findByPatientId(patientId);

        // Convert entities to DTOs
        return consultations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConsultationDTO> getConsultationsByDoctorId(Long doctorId) {
        // Retrieve consultations by doctor ID
        List<Consultation> consultations = consultationRepository.findByDoctorId(doctorId);

        // Convert entities to DTOs
        return consultations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteConsultation(Long id) throws ConsultationNotFoundException {
        // Check if consultation exists
        if (!consultationRepository.existsById(id)) {
            throw new ConsultationNotFoundException("Consultation not found with ID: " + id);
        }
        // Delete the consultation
        consultationRepository.deleteById(id);
    }

    @Override
    public List<DoctorDTO> getDoctorsByPatientId(Long patientId) {
        // Retrieve doctors associated with a patient
        List<Doctor> doctors = doctorRepository.findDoctorsByPatientId(patientId);

        // Convert entities to DTOs
        return doctors.stream()
                .map(this::convertToDoctorDTO)
                .collect(Collectors.toList());
    }

    // Helper method to validate consultation data
    private void validateConsultationData(ConsultationDTO consultationDTO) throws InvalidConsultationDataException {
        if (consultationDTO.getPatient() == null || consultationDTO.getDoctor() == null) {
            throw new InvalidConsultationDataException("Patient and Doctor information must be provided.");
        }
    }

    // Helper method to map DTO to entity
    private Consultation mapToEntity(ConsultationDTO consultationDTO, Consultation consultation) throws InvalidConsultationDataException {
        Patient patient = patientRepository.findById(consultationDTO.getPatient().getId())
                .orElseThrow(() -> new InvalidConsultationDataException("Patient not found"));
        Doctor doctor = doctorRepository.findById(consultationDTO.getDoctor().getId())
                .orElseThrow(() -> new InvalidConsultationDataException("Doctor not found"));

        consultation.setPatient(patient);
        consultation.setDoctor(doctor);
        consultation.setDateTime(consultationDTO.getDateTime());
        consultation.setNotes(consultationDTO.getNotes());
        consultation.setStatus(consultationDTO.getStatus());

        return consultation;
    }

    // Helper method to convert Consultation entity to ConsultationDTO
    private ConsultationDTO convertToDTO(Consultation consultation) {
        return ConsultationDTO.builder()
                .id(consultation.getId())
                .patient(convertToPatientDTO(consultation.getPatient()))
                .doctor(convertToDoctorDTO(consultation.getDoctor()))
                .dateTime(consultation.getDateTime())
                .notes(consultation.getNotes())
                .status(consultation.getStatus())
                .build();
    }

    // Helper method to convert Doctor entity to DoctorDTO
    private DoctorDTO convertToDoctorDTO(Doctor doctor) {
        return DoctorDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName()) // Assuming Doctor has a getName() method
                .build();
    }

    // Helper method to convert Patient entity to PatientDTO
    private PatientDTO convertToPatientDTO(Patient patient) {
        return PatientDTO.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName()) // Assuming Patient has a getFirstName() method
                .lastName(patient.getLastName()) // Assuming Patient has a getLastName() method
                .build();
    }
}
