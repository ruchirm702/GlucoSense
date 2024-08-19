package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class ActivityRecordNotFoundException extends RuntimeException {
    public ActivityRecordNotFoundException(String message) {
        super(message);
    }
}