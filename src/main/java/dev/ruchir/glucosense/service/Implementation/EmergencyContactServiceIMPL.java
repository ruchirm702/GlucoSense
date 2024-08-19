package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.ResourceNotFoundException;
import dev.ruchir.glucosense.dto.Support_dto.EmergencyContactDTO;
import dev.ruchir.glucosense.model.support.EmergencyContact;
import dev.ruchir.glucosense.repository.EmergencyContactRepository;
import dev.ruchir.glucosense.service.Interface.EmergencyContactService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmergencyContactServiceIMPL implements EmergencyContactService {

    private final EmergencyContactRepository emergencyContactRepository;
    private final ModelMapper modelMapper;

    public EmergencyContactServiceIMPL(EmergencyContactRepository emergencyContactRepository, ModelMapper modelMapper) {
        this.emergencyContactRepository = emergencyContactRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmergencyContactDTO> getEmergencyContactsByPatientId(Long patientId) {
        List<EmergencyContact> contacts = emergencyContactRepository.findByPatientId(patientId);
        return contacts.stream()
                .map(contact -> modelMapper.map(contact, EmergencyContactDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmergencyContactDTO getEmergencyContactById(Long id) {
        EmergencyContact contact = emergencyContactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emergency Contact not found"));
        return modelMapper.map(contact, EmergencyContactDTO.class);
    }

    @Override
    public EmergencyContactDTO createEmergencyContact(EmergencyContactDTO emergencyContactDTO) {
        EmergencyContact contact = modelMapper.map(emergencyContactDTO, EmergencyContact.class);
        contact = emergencyContactRepository.save(contact);
        return modelMapper.map(contact, EmergencyContactDTO.class);
    }

    @Override
    public EmergencyContactDTO updateEmergencyContact(Long id, EmergencyContactDTO emergencyContactDTO) {
        EmergencyContact existingContact = emergencyContactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emergency Contact not found"));
        modelMapper.map(emergencyContactDTO, existingContact);
        existingContact = emergencyContactRepository.save(existingContact);
        return modelMapper.map(existingContact, EmergencyContactDTO.class);
    }

    @Override
    public void deleteEmergencyContact(Long id) {
        EmergencyContact contact = emergencyContactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emergency Contact not found"));
        emergencyContactRepository.delete(contact);
    }
}
