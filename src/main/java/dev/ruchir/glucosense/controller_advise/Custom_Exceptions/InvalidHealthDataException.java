package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.BadRequestException;

public class InvalidHealthDataException extends BadRequestException {
    public InvalidHealthDataException() {
        super("Invalid health data provided.");
    }
}