package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.AppointmentConflictException;
import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.AppointmentNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.AppointmentDTO;
import dev.ruchir.glucosense.model.Core.Appointment;
import dev.ruchir.glucosense.model.Core.Doctor;
import dev.ruchir.glucosense.model.Core.Patient;
import dev.ruchir.glucosense.repository.AppointmentRepository;
import dev.ruchir.glucosense.repository.DoctorRepository;
import dev.ruchir.glucosense.repository.PatientRepository;
import dev.ruchir.glucosense.service.Interface.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  PatientRepository patientRepository,
                                  DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        Patient patient = getPatientById(appointmentDTO.getPatientId());
        Doctor doctor = getDoctorById(appointmentDTO.getDoctorId());

        Appointment appointment = buildAppointment(appointmentDTO, patient, doctor);

        // Check for appointment conflicts
        if (appointmentRepository.existsById(appointment.getId())) {
            throw new AppointmentConflictException("Appointment conflict detected.");
        }

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return convertToDTO(savedAppointment);
    }

    @Override
    public AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO) {
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with id: " + id));

        Patient patient = getPatientById(appointmentDTO.getPatientId());
        Doctor doctor = getDoctorById(appointmentDTO.getDoctorId());

        updateAppointmentDetails(existingAppointment, appointmentDTO, patient, doctor);

        // Check for appointment conflicts
        if (appointmentRepository.existsById(existingAppointment.getId())) {
            throw new AppointmentConflictException("Appointment conflict detected.");
        }

        Appointment updatedAppointment = appointmentRepository.save(existingAppointment);
        return convertToDTO(updatedAppointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new AppointmentNotFoundException("Appointment not found with id: " + id);
        }
        appointmentRepository.deleteById(id);
    }

    @Override
    public Optional<AppointmentDTO> getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private Patient getPatientById(Long patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));
    }

    private Doctor getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId));
    }

    private Appointment buildAppointment(AppointmentDTO dto, Patient patient, Doctor doctor) {
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setReason(dto.getReason());
        appointment.setStatus(dto.getStatus());
        return appointment;
    }

    private void updateAppointmentDetails(Appointment appointment, AppointmentDTO dto, Patient patient, Doctor doctor) {
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setReason(dto.getReason());
        appointment.setStatus(dto.getStatus());
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        return new AppointmentDTO(
                appointment.getId(),
                appointment.getPatient() != null ? appointment.getPatient().getId() : null,
                appointment.getDoctor() != null ? appointment.getDoctor().getId() : null,
                appointment.getAppointmentDate(),
                appointment.getReason(),
                appointment.getStatus()
        );
    }
}
