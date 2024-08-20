package dev.ruchir.glucosense.model.Enum;

public enum PrescriptionStatus {
    PENDING,          // Prescription is created but not yet processed.
    APPROVED,         // Prescription has been reviewed and approved.
    DISPENSED,        // Medication has been given to the patient.
    REJECTED,         // Prescription was not approved, possibly due to issues or errors.
    CANCELED,         // Prescription has been canceled, might need to track reasons.
    EXPIRED           // Prescription is no longer valid due to time expiration.
}
