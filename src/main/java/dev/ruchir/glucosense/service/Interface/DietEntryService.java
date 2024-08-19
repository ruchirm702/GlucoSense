package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.dto.Core_Dto.DietEntryDTO;
import dev.ruchir.glucosense.model.Enum.DietType;

import java.util.List;

public interface DietEntryService {
    DietEntryDTO createDietEntry(DietEntryDTO dietEntryDTO);
    DietEntryDTO getDietEntryById(Long id);
    List<DietEntryDTO> getDietEntriesByPatientId(Long patientId);
    List<DietEntryDTO> getDietEntriesByDietType(DietType dietType);
    DietEntryDTO updateDietEntry(Long id, DietEntryDTO dietEntryDTO);
    void deleteDietEntry(Long id);
}
