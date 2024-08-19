package dev.ruchir.glucosense.service.Implementation;


import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.DietEntryNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.DietEntryDTO;
import dev.ruchir.glucosense.model.Core.DietEntry;
import dev.ruchir.glucosense.model.Enum.DietType;
import dev.ruchir.glucosense.repository.DietEntryRepository;
import dev.ruchir.glucosense.service.Interface.DietEntryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DietEntryServiceIMPL implements DietEntryService {
    private final DietEntryRepository dietEntryRepository;
    private final ModelMapper modelMapper;

    public DietEntryServiceIMPL(DietEntryRepository dietEntryRepository, ModelMapper modelMapper) {
        this.dietEntryRepository = dietEntryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DietEntryDTO createDietEntry(DietEntryDTO dietEntryDTO) {
        DietEntry dietEntry = modelMapper.map(dietEntryDTO, DietEntry.class);
        dietEntry = dietEntryRepository.save(dietEntry);
        return modelMapper.map(dietEntry, DietEntryDTO.class);
    }

    @Override
    public DietEntryDTO getDietEntryById(Long id) {
        DietEntry dietEntry = dietEntryRepository.findById(id)
                .orElseThrow(() -> new DietEntryNotFoundException("DietEntry not found"));
        return modelMapper.map(dietEntry, DietEntryDTO.class);
    }

    @Override
    public List<DietEntryDTO> getDietEntriesByPatientId(Long patientId) {
        List<DietEntry> dietEntries = dietEntryRepository.findByPatientId(patientId);
        return dietEntries.stream()
                .map(dietEntry -> modelMapper.map(dietEntry, DietEntryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DietEntryDTO> getDietEntriesByDietType(DietType dietType) {
        List<DietEntry> dietEntries = dietEntryRepository.findByDietType(dietType);
        return dietEntries.stream()
                .map(dietEntry -> modelMapper.map(dietEntry, DietEntryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DietEntryDTO updateDietEntry(Long id, DietEntryDTO dietEntryDTO) {
        DietEntry existingDietEntry = dietEntryRepository.findById(id)
                .orElseThrow(() -> new DietEntryNotFoundException("DietEntry not found"));
        modelMapper.map(dietEntryDTO, existingDietEntry);
        existingDietEntry = dietEntryRepository.save(existingDietEntry);
        return modelMapper.map(existingDietEntry, DietEntryDTO.class);
    }

    @Override
    public void deleteDietEntry(Long id) {
        DietEntry dietEntry = dietEntryRepository.findById(id)
                .orElseThrow(() -> new DietEntryNotFoundException("DietEntry not found"));
        dietEntryRepository.delete(dietEntry);
    }
}
