package dev.ruchir.glucosense.controller_advise;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.*;
import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

    // Patient Service Exceptions
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePatientNotFound(PatientNotFoundException ex) {
        log.error("Patient not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "PATIENT_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    // BloodSugarRecord Service Exceptions
    @ExceptionHandler(BloodSugarRecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBloodSugarRecordNotFound(BloodSugarRecordNotFoundException ex) {
        log.error("Blood sugar record not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "BLOOD_SUGAR_RECORD_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    // DietEntry Service Exceptions
    @ExceptionHandler(DietEntryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDietEntryNotFound(DietEntryNotFoundException ex) {
        log.error("Diet entry not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "DIET_ENTRY_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    // ActivityRecord Service Exceptions
    @ExceptionHandler(ActivityRecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleActivityRecordNotFound(ActivityRecordNotFoundException ex) {
        log.error("Activity record not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "ACTIVITY_RECORD_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    // Measurement Service Exceptions
    @ExceptionHandler(MeasurementNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMeasurementNotFound(MeasurementNotFoundException ex) {
        log.error("Measurement not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "MEASUREMENT_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    // Invalid Health Data Exception
    @ExceptionHandler(InvalidHealthDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidHealthData(InvalidHealthDataException ex) {
        log.error("Invalid health data provided: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "INVALID_HEALTH_DATA", HttpStatus.BAD_REQUEST);
    }

    // Resource Not Found Exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        log.error("Resource not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "RESOURCE_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    // Bad Request Exception
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex) {
        log.error("Bad request: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "BAD_REQUEST", HttpStatus.BAD_REQUEST);
    }

    // Data Integrity Violation Exception
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        log.error("Data integrity violation: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "DATA_INTEGRITY_VIOLATION", HttpStatus.CONFLICT);
    }

    // Unauthorized Access Exception
    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedAccess(UnauthorizedAccessException ex) {
        log.error("Unauthorized access: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "UNAUTHORIZED_ACCESS", HttpStatus.UNAUTHORIZED);
    }

    // Service Exception
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex) {
        log.error("Service exception: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "SERVICE_EXCEPTION", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Appointment Service Exceptions
    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAppointmentNotFound(AppointmentNotFoundException ex) {
        log.error("Appointment not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "APPOINTMENT_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AppointmentConflictException.class)
    public ResponseEntity<ErrorResponse> handleAppointmentConflict(AppointmentConflictException ex) {
        log.error("Appointment conflict: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "APPOINTMENT_CONFLICT", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidAppointmentStatusException.class)
    public ResponseEntity<ErrorResponse> handleInvalidAppointmentStatus(InvalidAppointmentStatusException ex) {
        log.error("Invalid appointment status: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "INVALID_APPOINTMENT_STATUS", HttpStatus.BAD_REQUEST);
    }

    // User Service Exceptions
    @ExceptionHandler(dev.ruchir.glucosense.exception.UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(dev.ruchir.glucosense.exception.UserNotFoundException ex) {
        log.error("User not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "USER_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    // Consultation Service Exceptions
    @ExceptionHandler(ConsultationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleConsultationNotFoundException(ConsultationNotFoundException ex) {
        log.error("Consultation not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "CONSULTATION_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    // Doctor Service Exceptions
    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDoctorNotFoundException(DoctorNotFoundException ex) {
        log.error("Doctor not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "DOCTOR_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    // Medication Service Exceptions
    @ExceptionHandler(MedicationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMedicationNotFoundException(MedicationNotFoundException ex) {
        log.error("Medication not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "MEDICATION_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    // EmergencyContact Service Exceptions
    @ExceptionHandler(EmergencyContactNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmergencyContactNotFoundException(EmergencyContactNotFoundException ex) {
        log.error("Emergency contact not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "EMERGENCY_CONTACT_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    // Device Service Exceptions
    @ExceptionHandler(DeviceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDeviceNotFoundException(DeviceNotFoundException ex) {
        log.error("Device not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "DEVICE_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    // Role Service Exceptions
    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRoleNotFoundException(RoleNotFoundException ex) {
        log.error("Role not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "ROLE_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    // Invalid Consultation Data Exception
    @ExceptionHandler(InvalidConsultationDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidConsultationDataException(InvalidConsultationDataException ex) {
        log.error("Invalid consultation data: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "INVALID_CONSULTATION_DATA", HttpStatus.BAD_REQUEST);
    }

    // Notification Service Exceptions
    @ExceptionHandler(NotificationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotificationNotFoundException(NotificationNotFoundException ex) {
        log.error("Notification not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "NOTIFICATION_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotificationAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleNotificationAlreadyExistsException(NotificationAlreadyExistsException ex) {
        log.error("Notification already exists: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "NOTIFICATION_ALREADY_EXISTS", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidNotificationDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidNotificationDataException(InvalidNotificationDataException ex) {
        log.error("Invalid notification data: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "INVALID_NOTIFICATION_DATA", HttpStatus.BAD_REQUEST);
    }

    // Billing Service Exceptions
    @ExceptionHandler(BillingNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBillingNotFoundException(BillingNotFoundException ex) {
        log.error("Billing not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "BILLING_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePaymentNotFoundException(PaymentNotFoundException ex) {
        log.error("Payment not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "PAYMENT_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPaymentDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPaymentDataException(InvalidPaymentDataException ex) {
        log.error("Invalid payment data: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "INVALID_PAYMENT_DATA", HttpStatus.BAD_REQUEST);
    }
    // Prescription Service Exceptions
    @ExceptionHandler(PrescriptionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePrescriptionNotFound(PrescriptionNotFoundException ex) {
        log.error("Prescription not found: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "PRESCRIPTION_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPrescriptionDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPrescriptionData(InvalidPrescriptionDataException ex) {
        log.error("Invalid prescription data: {}", ex.getMessage());
        return buildErrorResponse(ex.getMessage(), "INVALID_PRESCRIPTION_DATA", HttpStatus.BAD_REQUEST);
    }
}
