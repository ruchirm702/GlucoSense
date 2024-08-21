package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class InvalidInsuranceDataException extends RuntimeException {
    public InvalidInsuranceDataException(String message) {
        super(message);
    }
}