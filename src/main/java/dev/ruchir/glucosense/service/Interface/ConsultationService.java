package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.ConsultationNotFoundException;
import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.InvalidConsultationDataException;
import dev.ruchir.glucosense.dto.Core_Dto.ConsultationDTO;
import dev.ruchir.glucosense.dto.Core_Dto.DoctorDTO;

import java.util.List;

/**
 * Service interface for managing consultations.
 */
public interface ConsultationService {

    /**
     * Create a new consultation.
     *
     * @param consultationDTO the consultation data
     * @return the created consultation
     * @throws InvalidConsultationDataException if the data provided is invalid
     */
    ConsultationDTO createConsultation(ConsultationDTO consultationDTO) throws InvalidConsultationDataException;

    /**
     * Update an existing consultation.
     *
     * @param id              the consultation ID
     * @param consultationDTO the updated consultation data
     * @return the updated consultation
     * @throws ConsultationNotFoundException if the consultation with the given ID does not exist
     * @throws InvalidConsultationDataException if the data provided is invalid
     */
    ConsultationDTO updateConsultation(Long id, ConsultationDTO consultationDTO)
            throws ConsultationNotFoundException, InvalidConsultationDataException;

    /**
     * Retrieve a consultation by its ID.
     *
     * @param id the consultation ID
     * @return the consultation
     * @throws ConsultationNotFoundException if the consultation with the given ID does not exist
     */
    ConsultationDTO getConsultationById(Long id) throws ConsultationNotFoundException;

    /**
     * Retrieve consultations for a specific patient.
     *
     * @param patientId the patient ID
     * @return a list of consultations
     */
    List<ConsultationDTO> getConsultationsByPatientId(Long patientId);

    /**
     * Retrieve consultations for a specific doctor.
     *
     * @param doctorId the doctor ID
     * @return a list of consultations
     */
    List<ConsultationDTO> getConsultationsByDoctorId(Long doctorId);

    /**
     * Delete a consultation by its ID.
     *
     * @param id the consultation ID
     * @throws ConsultationNotFoundException if the consultation with the given ID does not exist
     */
    void deleteConsultation(Long id) throws ConsultationNotFoundException;

    /**
     * Retrieve doctors associated with a specific patient.
     *
     * @param patientId the patient ID
     * @return a list of doctors
     */
    List<DoctorDTO> getDoctorsByPatientId(Long patientId);
}