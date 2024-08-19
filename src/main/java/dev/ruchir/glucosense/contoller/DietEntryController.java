package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.dto.Core_Dto.DietEntryDTO;
import dev.ruchir.glucosense.model.Enum.DietType;
import dev.ruchir.glucosense.service.Interface.DietEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diet-entries")
public class DietEntryController {

    private final DietEntryService dietEntryService;

    public DietEntryController(DietEntryService dietEntryService) {
        this.dietEntryService = dietEntryService;
    }

    @PostMapping
    public ResponseEntity<DietEntryDTO> createDietEntry(@RequestBody DietEntryDTO dietEntryDTO) {
        DietEntryDTO createdDietEntry = dietEntryService.createDietEntry(dietEntryDTO);
        return new ResponseEntity<>(createdDietEntry, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DietEntryDTO> getDietEntryById(@PathVariable Long id) {
        DietEntryDTO dietEntry = dietEntryService.getDietEntryById(id);
        return new ResponseEntity<>(dietEntry, HttpStatus.OK);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<DietEntryDTO>> getDietEntriesByPatientId(@PathVariable Long patientId) {
        List<DietEntryDTO> dietEntries = dietEntryService.getDietEntriesByPatientId(patientId);
        return new ResponseEntity<>(dietEntries, HttpStatus.OK);
    }

    @GetMapping("/diet-type/{dietType}")
    public ResponseEntity<List<DietEntryDTO>> getDietEntriesByDietType(@PathVariable DietType dietType) {
        List<DietEntryDTO> dietEntries = dietEntryService.getDietEntriesByDietType(dietType);
        return new ResponseEntity<>(dietEntries, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DietEntryDTO> updateDietEntry(@PathVariable Long id, @RequestBody DietEntryDTO dietEntryDTO) {
        DietEntryDTO updatedDietEntry = dietEntryService.updateDietEntry(id, dietEntryDTO);
        return new ResponseEntity<>(updatedDietEntry, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDietEntry(@PathVariable Long id) {
        dietEntryService.deleteDietEntry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
