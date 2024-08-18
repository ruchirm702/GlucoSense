package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.dto.Core_Dto.BloodSugarRecordDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface BloodSugarRecordService {
    BloodSugarRecordDTO createBloodSugarRecord(BloodSugarRecordDTO bloodSugarRecordDTO);
    BloodSugarRecordDTO getBloodSugarRecordById(Long id);
    List<BloodSugarRecordDTO> getAllBloodSugarRecords();
    List<BloodSugarRecordDTO> getBloodSugarRecordsByPatientId(Long patientId);
    List<BloodSugarRecordDTO> getBloodSugarRecordsBetweenDates(LocalDateTime start, LocalDateTime end);
    BloodSugarRecordDTO updateBloodSugarRecord(Long id, BloodSugarRecordDTO bloodSugarRecordDTO);
    void deleteBloodSugarRecord(Long id);
}
