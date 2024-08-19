package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.ActivityRecordNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.ActivityRecordDTO;
import dev.ruchir.glucosense.service.Interface.ActivityRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-records")
public class ActivityRecordController {

    private final ActivityRecordService activityRecordService;

    public ActivityRecordController(ActivityRecordService activityRecordService) {
        this.activityRecordService = activityRecordService;
    }

    @PostMapping
    public ResponseEntity<ActivityRecordDTO> createActivityRecord(@RequestBody ActivityRecordDTO activityRecordDTO) {
        ActivityRecordDTO createdActivityRecord = activityRecordService.createActivityRecord(activityRecordDTO);
        return new ResponseEntity<>(createdActivityRecord, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityRecordDTO> updateActivityRecord(@PathVariable Long id, @RequestBody ActivityRecordDTO activityRecordDTO) {
        ActivityRecordDTO updatedActivityRecord = activityRecordService.updateActivityRecord(id, activityRecordDTO);
        return new ResponseEntity<>(updatedActivityRecord, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityRecordDTO> getActivityRecordById(@PathVariable Long id) {
        ActivityRecordDTO activityRecordDTO = activityRecordService.getActivityRecordById(id);
        return new ResponseEntity<>(activityRecordDTO, HttpStatus.OK);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ActivityRecordDTO>> getActivityRecordsByPatientId(@PathVariable Long patientId) {
        List<ActivityRecordDTO> activityRecordsDTO = activityRecordService.getActivityRecordsByPatientId(patientId);
        return new ResponseEntity<>(activityRecordsDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivityRecord(@PathVariable Long id) {
        activityRecordService.deleteActivityRecord(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(ActivityRecordNotFoundException.class)
    public ResponseEntity<String> handleActivityRecordNotFound(ActivityRecordNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
