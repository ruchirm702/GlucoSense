package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.ResourceNotFoundException;

public class BloodSugarRecordNotFoundException extends ResourceNotFoundException {
    public BloodSugarRecordNotFoundException(Long id) {
        super("Blood sugar record with ID " + id + " not found.");
    }
}