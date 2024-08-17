package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.ResourceNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.*;
import dev.ruchir.glucosense.dto.Support_dto.DeviceDTO;
import dev.ruchir.glucosense.dto.Support_dto.EmergencyContactDTO;
import dev.ruchir.glucosense.dto.Support_dto.LabResultDTO;
import dev.ruchir.glucosense.dto.Support_dto.RoleDTO;
import dev.ruchir.glucosense.model.Core.*;
import dev.ruchir.glucosense.model.Enum.BloodType;
import dev.ruchir.glucosense.model.support.Device;
import dev.ruchir.glucosense.model.support.EmergencyContact;
import dev.ruchir.glucosense.model.support.LabResult;
import dev.ruchir.glucosense.model.support.Role;
import dev.ruchir.glucosense.repository.*;
import dev.ruchir.glucosense.service.Interface.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceIMPL implements PatientService {
    private final PatientRepository patientRepository;
    private final ActivityRecordRepository activityRecordRepository;
    private final BloodSugarRecordRepository bloodSugarRecordRepository;
    private final ConsultationRepository consultationRepository;
    private final DeviceRepository deviceRepository;
    private final DietEntryRepository dietEntryRepository;
    private final EmergencyContactRepository emergencyContactRepository;
    private final LabResultRepository labResultRepository;
    private final MeasurementRepository measurementRepository;
    private final MedicationRepository medicationRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public PatientServiceIMPL(PatientRepository patientRepository,
                              ActivityRecordRepository activityRecordRepository,
                              BloodSugarRecordRepository bloodSugarRecordRepository,
                              ConsultationRepository consultationRepository,
                              DeviceRepository deviceRepository,
                              DietEntryRepository dietEntryRepository,
                              EmergencyContactRepository emergencyContactRepository,
                              LabResultRepository labResultRepository,
                              MeasurementRepository measurementRepository,
                              MedicationRepository medicationRepository,
                              RoleRepository roleRepository,
                              ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
        this.activityRecordRepository = activityRecordRepository;
        this.bloodSugarRecordRepository = bloodSugarRecordRepository;
        this.consultationRepository = consultationRepository;
        this.deviceRepository = deviceRepository;
        this.dietEntryRepository = dietEntryRepository;
        this.emergencyContactRepository = emergencyContactRepository;
        this.labResultRepository = labResultRepository;
        this.measurementRepository = measurementRepository;
        this.medicationRepository = medicationRepository;
        this.roleRepository = roleRepository;
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
    public List<PatientDTO> getPatientsByName(String name) {
        return patientRepository.findByName(name)
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

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        modelMapper.map(patientDTO, existingPatient);
        existingPatient = patientRepository.save(existingPatient);
        return modelMapper.map(existingPatient, PatientDTO.class);
    }

    @Override
    public List<ActivityRecordDTO> getActivityRecordsByPatientId(Long patientId) {
        List<ActivityRecord> activityRecords = activityRecordRepository.findByPatientId(patientId);
        return activityRecords.stream()
                .map(activityRecord -> modelMapper.map(activityRecord, ActivityRecordDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BloodSugarRecordDTO> getBloodSugarRecordsByPatientId(Long patientId) {
        List<BloodSugarRecord> bloodSugarRecords = bloodSugarRecordRepository.findByPatientId(patientId);
        return bloodSugarRecords.stream()
                .map(record -> modelMapper.map(record, BloodSugarRecordDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DietEntryDTO> getDietEntriesByPatientId(Long patientId) {
        List<DietEntry> dietEntries = dietEntryRepository.findByPatientId(patientId);
        return dietEntries.stream()
                .map(entry -> modelMapper.map(entry, DietEntryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ConsultationDTO> getConsultationsByPatientId(Long patientId) {
        List<Consultation> consultations = consultationRepository.findByPatientId(patientId);
        return consultations.stream()
                .map(consultation -> modelMapper.map(consultation, ConsultationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DeviceDTO> getDevicesByPatientId(Long patientId) {
        List<Device> devices = deviceRepository.findByPatientId(patientId);
        return devices.stream()
                .map(device -> modelMapper.map(device, DeviceDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmergencyContactDTO> getEmergencyContactsByPatientId(Long patientId) {
        List<EmergencyContact> emergencyContacts = emergencyContactRepository.findByPatientId(patientId);
        return emergencyContacts.stream()
                .map(contact -> modelMapper.map(contact, EmergencyContactDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LabResultDTO> getLabResultsByPatientId(Long patientId) {
        List<LabResult> labResults = labResultRepository.findByPatientId(patientId);
        return labResults.stream()
                .map(result -> modelMapper.map(result, LabResultDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MeasurementDTO> getMeasurementsByPatientId(Long patientId) {
        List<Measurement> measurements = measurementRepository.findByPatientId(patientId);
        return measurements.stream()
                .map(measurement -> modelMapper.map(measurement, MeasurementDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicationDTO> getMedicationsByPatientId(Long patientId) {
        List<Medication> medications = medicationRepository.findByPatientId(patientId);
        return medications.stream()
                .map(medication -> modelMapper.map(medication, MedicationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DoctorDTO> getDoctorsByPatientId(Long patientId) {
        List<Doctor> doctors = consultationRepository.findDoctorsByPatientId(patientId);
        return doctors.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<RoleDTO> getRolesByPatientId(Long patientId) {
        List<Role> roles = roleRepository.findByPatientId(patientId);
        return roles.stream()
                .map(role -> modelMapper.map(role, RoleDTO.class))
                .collect(Collectors.toList());
    }
}
