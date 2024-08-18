package dev.ruchir.glucosense.controller_advise;


import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.*;
import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private ResponseEntity<ErrorResponse> buildErrorResponse(String message, String errorCode, HttpStatus status) {
        ErrorResponse errorResponse = new ErrorResponse(
                message,
                errorCode,
                LocalDateTime.now(),
                status,
                generateErrorId() // Optionally include a unique error ID
        );
        return new ResponseEntity<>(errorResponse, status);
    }

    private String generateErrorId() {
        return UUID.randomUUID().toString(); // Generate a unique ID for tracking errors
    }

    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handlePatientNotFound(PatientNotFoundException ex) {
        log.error("Patient not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "PATIENT_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BloodSugarRecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleBloodSugarRecordNotFound(BloodSugarRecordNotFoundException ex) {
        log.error("Blood sugar record not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "BLOOD_SUGAR_RECORD_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DietEntryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleDietEntryNotFound(DietEntryNotFoundException ex) {
        log.error("Diet entry not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "DIET_ENTRY_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ActivityRecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleActivityRecordNotFound(ActivityRecordNotFoundException ex) {
        log.error("Activity record not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "ACTIVITY_RECORD_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MeasurementNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleMeasurementNotFound(MeasurementNotFoundException ex) {
        log.error("Measurement not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "MEASUREMENT_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidHealthDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleInvalidHealthData(InvalidHealthDataException ex) {
        log.error("Invalid health data provided: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "INVALID_HEALTH_DATA", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        log.error("Resource not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "RESOURCE_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex) {
        log.error("Bad request: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "BAD_REQUEST", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        log.error("Data integrity violation: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "DATA_INTEGRITY_VIOLATION", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorResponse> handleUnauthorizedAccess(UnauthorizedAccessException ex) {
        log.error("Unauthorized access: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "UNAUTHORIZED_ACCESS", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex) {
        log.error("Service exception: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "SERVICE_EXCEPTION", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        log.error("An unexpected error occurred: {}", ex.getMessage());
        return buildErrorResponse("An unexpected error occurred", "INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(dev.ruchir.glucosense.exception.UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleUserNotFound(dev.ruchir.glucosense.exception.UserNotFoundException ex) {
        log.error("User not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "USER_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConsultationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleConsultationNotFoundException(ConsultationNotFoundException ex) {
        log.error("Consultation not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "CONSULTATION_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DoctorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleDoctorNotFoundException(DoctorNotFoundException ex) {
        log.error("Doctor not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "DOCTOR_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MedicationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleMedicationNotFoundException(MedicationNotFoundException ex) {
        log.error("Medication not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "MEDICATION_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmergencyContactNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleEmergencyContactNotFoundException(EmergencyContactNotFoundException ex) {
        log.error("Emergency contact not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "EMERGENCY_CONTACT_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DeviceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleDeviceNotFoundException(DeviceNotFoundException ex) {
        log.error("Device not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "DEVICE_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleRoleNotFoundException(RoleNotFoundException ex) {
        log.error("Role not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "ROLE_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidConsultationDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleInvalidConsultationDataException(InvalidConsultationDataException ex) {
        log.error("Invalid consultation data: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "INVALID_CONSULTATION_DATA", HttpStatus.BAD_REQUEST);
    }
}
