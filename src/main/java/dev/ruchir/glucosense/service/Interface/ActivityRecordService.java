package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.dto.Core_Dto.ActivityRecordDTO;

import java.util.List;

public interface ActivityRecordService {

    /**
     * Create a new activity record.
     *
     * @param activityRecordDTO the activity record data transfer object
     * @return the created ActivityRecordDTO
     */
    ActivityRecordDTO createActivityRecord(ActivityRecordDTO activityRecordDTO);

    /**
     * Update an existing activity record.
     *
     * @param id the ID of the activity record to update
     * @param activityRecordDTO the updated activity record data transfer object
     * @return the updated ActivityRecordDTO
     */
    ActivityRecordDTO updateActivityRecord(Long id, ActivityRecordDTO activityRecordDTO);

    /**
     * Get an activity record by ID.
     *
     * @param id the ID of the activity record
     * @return the ActivityRecordDTO
     */
    ActivityRecordDTO getActivityRecordById(Long id);

    /**
     * Get all activity records for a specific patient.
     *
     * @param patientId the ID of the patient
     * @return a list of ActivityRecordDTOs
     */
    List<ActivityRecordDTO> getActivityRecordsByPatientId(Long patientId);

    /**
     * Delete an activity record by ID.
     *
     * @param id the ID of the activity record
     */
    void deleteActivityRecord(Long id);
}
