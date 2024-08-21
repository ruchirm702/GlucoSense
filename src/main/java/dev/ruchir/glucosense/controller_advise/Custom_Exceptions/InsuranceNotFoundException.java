package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class InsuranceNotFoundException extends RuntimeException {
    public InsuranceNotFoundException(String message) {
        super(message);
    }
}