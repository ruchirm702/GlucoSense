package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.ResourceNotFoundException;

public class PatientNotFoundException extends ResourceNotFoundException {
    public PatientNotFoundException(String message) {
        super(message);
    }
}
