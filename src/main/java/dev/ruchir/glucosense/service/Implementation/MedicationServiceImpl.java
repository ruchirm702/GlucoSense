package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.MedicationNotFoundException;
import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.BadRequestException;
import dev.ruchir.glucosense.dto.Core_Dto.MedicationDTO;
import dev.ruchir.glucosense.dto.Enum_dto.MedicationTypeDTO;
import dev.ruchir.glucosense.model.Core.Medication;
import dev.ruchir.glucosense.repository.MedicationRepository;
import dev.ruchir.glucosense.service.Interface.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationServiceImpl(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public MedicationDTO createMedication(MedicationDTO medicationDTO) throws BadRequestException {
        if (medicationDTO == null) {
            throw new BadRequestException("Medication data must not be null");
        }

        Medication medication = new Medication();
        medication.setName(medicationDTO.getName());
        medication.setDosage(medicationDTO.getDosage());
        medication.setType(medicationDTO.getType().toMedicationType());

        medication = medicationRepository.save(medication);

        return convertToDTO(medication);
    }

    @Override
    public MedicationDTO updateMedication(Long id, MedicationDTO medicationDTO) throws MedicationNotFoundException, BadRequestException {
        if (medicationDTO == null) {
            throw new BadRequestException("Medication data must not be null");
        }

        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new MedicationNotFoundException("Medication not found with id: " + id));

        medication.setName(medicationDTO.getName());
        medication.setDosage(medicationDTO.getDosage());
        medication.setType(medicationDTO.getType().toMedicationType());

        medication = medicationRepository.save(medication);

        return convertToDTO(medication);
    }

    @Override
    public void deleteMedication(Long id) throws MedicationNotFoundException {
        if (!medicationRepository.existsById(id)) {
            throw new MedicationNotFoundException("Medication not found with id: " + id);
        }
        medicationRepository.deleteById(id);
    }

    @Override
    public MedicationDTO getMedicationById(Long id) throws MedicationNotFoundException {
        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new MedicationNotFoundException("Medication not found with id: " + id));
        return convertToDTO(medication);
    }

    @Override
    public List<MedicationDTO> getAllMedications() {
        return medicationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicationDTO> getMedicationsByPatientId(Long patientId) {
        return medicationRepository.findByPatientId(patientId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicationDTO> getMedicationsByName(String name) {
        return medicationRepository.findByName(name).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private MedicationDTO convertToDTO(Medication medication) {
        MedicationDTO dto = new MedicationDTO();
        dto.setId(medication.getId());
        dto.setName(medication.getName());
        dto.setDosage(medication.getDosage());
        dto.setType(MedicationTypeDTO.fromMedicationType(medication.getType()));
        return dto;
    }
}
