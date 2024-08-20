package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class InvalidPaymentDataException extends RuntimeException {
    public InvalidPaymentDataException(String message) {
        super(message);
    }
}
