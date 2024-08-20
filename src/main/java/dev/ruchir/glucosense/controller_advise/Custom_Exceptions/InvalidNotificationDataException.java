package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class InvalidNotificationDataException extends RuntimeException {
    public InvalidNotificationDataException(String message) {
        super(message);
    }
}