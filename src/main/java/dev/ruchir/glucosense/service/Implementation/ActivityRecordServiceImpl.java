package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.ActivityRecordNotFoundException;
import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.PatientNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.ActivityRecordDTO;
import dev.ruchir.glucosense.dto.Core_Dto.PatientDTO;
import dev.ruchir.glucosense.dto.Enum_dto.ActivityTypeDTO;
import dev.ruchir.glucosense.model.Core.ActivityRecord;
import dev.ruchir.glucosense.model.Core.Patient;
import dev.ruchir.glucosense.model.Enum.ActivityType;
import dev.ruchir.glucosense.repository.ActivityRecordRepository;
import dev.ruchir.glucosense.repository.PatientRepository;
import dev.ruchir.glucosense.service.Interface.ActivityRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityRecordServiceImpl implements ActivityRecordService {

    private final ActivityRecordRepository activityRecordRepository;
    private final PatientRepository patientRepository;

    // Constructor-based dependency injection
    public ActivityRecordServiceImpl(ActivityRecordRepository activityRecordRepository, PatientRepository patientRepository) {
        this.activityRecordRepository = activityRecordRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public ActivityRecordDTO createActivityRecord(ActivityRecordDTO activityRecordDTO) {
        ActivityRecord activityRecord = convertToEntity(activityRecordDTO);
        ActivityRecord savedActivityRecord = activityRecordRepository.save(activityRecord);
        return convertToDTO(savedActivityRecord);
    }

    @Override
    public ActivityRecordDTO updateActivityRecord(Long id, ActivityRecordDTO activityRecordDTO) {
        ActivityRecord existingRecord = activityRecordRepository.findById(id)
                .orElseThrow(() -> new ActivityRecordNotFoundException("Activity record not found with id: " + id));

        existingRecord.setActivityDate(activityRecordDTO.getStartTime());
        existingRecord.setActivityDescription(activityRecordDTO.getActivityDescription());
        existingRecord.setDuration(activityRecordDTO.getEndTime().getMinute() - activityRecordDTO.getStartTime().getMinute());
        existingRecord.setActivityType(ActivityType.valueOf(activityRecordDTO.getActivityType().getTypeName()));

        ActivityRecord updatedActivityRecord = activityRecordRepository.save(existingRecord);
        return convertToDTO(updatedActivityRecord);
    }

    @Override
    public ActivityRecordDTO getActivityRecordById(Long id) {
        ActivityRecord activityRecord = activityRecordRepository.findById(id)
                .orElseThrow(() -> new ActivityRecordNotFoundException("Activity record not found with id: " + id));
        return convertToDTO(activityRecord);
    }

    @Override
    public List<ActivityRecordDTO> getActivityRecordsByPatientId(Long patientId) {
        List<ActivityRecord> activityRecords = activityRecordRepository.findByPatientId(patientId);
        return activityRecords.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteActivityRecord(Long id) {
        if (!activityRecordRepository.existsById(id)) {
            throw new ActivityRecordNotFoundException("Activity record not found with id: " + id);
        }
        activityRecordRepository.deleteById(id);
    }

    private ActivityRecordDTO convertToDTO(ActivityRecord activityRecord) {
        return new ActivityRecordDTO(
                activityRecord.getId(),
                convertToPatientDTO(activityRecord.getPatient()),
                new ActivityTypeDTO(activityRecord.getActivityType().name()),
                activityRecord.getActivityDate(),
                activityRecord.getActivityDate().plusMinutes(activityRecord.getDuration()),
                calculateCaloriesBurned(activityRecord),
                activityRecord.getActivityDescription()
        );
    }

    private ActivityRecord convertToEntity(ActivityRecordDTO activityRecordDTO) {
        Patient patient = patientRepository.findById(activityRecordDTO.getPatient().getId())
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + activityRecordDTO.getPatient().getId()));

        return new ActivityRecord(
                activityRecordDTO.getId(),
                patient,
                activityRecordDTO.getStartTime(),
                activityRecordDTO.getActivityDescription(),
                activityRecordDTO.getEndTime().getMinute() - activityRecordDTO.getStartTime().getMinute(),
                ActivityType.valueOf(activityRecordDTO.getActivityType().getTypeName())
        );
    }

    private int calculateCaloriesBurned(ActivityRecord activityRecord) {
        // Add logic to calculate calories burned based on activity details.
        return 0; // Placeholder
    }

    private PatientDTO convertToPatientDTO(Patient patient) {
        // Conversion logic here
        return new PatientDTO();
    }
}
