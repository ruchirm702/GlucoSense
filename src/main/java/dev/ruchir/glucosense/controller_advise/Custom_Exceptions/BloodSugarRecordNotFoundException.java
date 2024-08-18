package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class BloodSugarRecordNotFoundException extends RuntimeException {
    public BloodSugarRecordNotFoundException(String message) {
        super(message);
    }
}
