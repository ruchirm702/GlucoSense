package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.dto.Support_dto.EmergencyContactDTO;
import dev.ruchir.glucosense.service.Interface.EmergencyContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergency-contacts")
public class EmergencyContactController {

    private final EmergencyContactService emergencyContactService;

    public EmergencyContactController(EmergencyContactService emergencyContactService) {
        this.emergencyContactService = emergencyContactService;
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<EmergencyContactDTO>> getEmergencyContactsByPatientId(@PathVariable Long patientId) {
        List<EmergencyContactDTO> contacts = emergencyContactService.getEmergencyContactsByPatientId(patientId);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyContactDTO> getEmergencyContactById(@PathVariable Long id) {
        EmergencyContactDTO contact = emergencyContactService.getEmergencyContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmergencyContactDTO> createEmergencyContact(@RequestBody EmergencyContactDTO emergencyContactDTO) {
        EmergencyContactDTO createdContact = emergencyContactService.createEmergencyContact(emergencyContactDTO);
        return new ResponseEntity<>(createdContact, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmergencyContactDTO> updateEmergencyContact(@PathVariable Long id, @RequestBody EmergencyContactDTO emergencyContactDTO) {
        EmergencyContactDTO updatedContact = emergencyContactService.updateEmergencyContact(id, emergencyContactDTO);
        return new ResponseEntity<>(updatedContact, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmergencyContact(@PathVariable Long id) {
        emergencyContactService.deleteEmergencyContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
