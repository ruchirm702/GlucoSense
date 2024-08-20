package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class InvalidBillingDataException extends RuntimeException {
    public InvalidBillingDataException(String message) {
        super(message);
    }
}
