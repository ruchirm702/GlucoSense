package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class PaymentProcessingException extends RuntimeException {
    public PaymentProcessingException(String message) {
        super(message);
    }
}
