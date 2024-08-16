package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.ResourceNotFoundException;

public class DietEntryNotFoundException extends ResourceNotFoundException {
    public DietEntryNotFoundException(String message) {
        super(message);
    }
}
