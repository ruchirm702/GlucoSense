package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.ResourceNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.DoctorDTO;
import dev.ruchir.glucosense.model.Core.Doctor;
import dev.ruchir.glucosense.model.support.Role;
import dev.ruchir.glucosense.repository.DoctorRepository;
import dev.ruchir.glucosense.repository.RoleRepository;
import dev.ruchir.glucosense.service.Interface.DoctorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Override
    public DoctorDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
        return mapToDTO(doctor);
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Role role = roleRepository.findById(doctorDTO.getRoleId())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + doctorDTO.getRoleId()));

        Doctor doctor = mapToEntity(doctorDTO);
        doctor.setRole(role); // Assign the role

        doctor = doctorRepository.save(doctor);
        return mapToDTO(doctor);
    }

    @Override
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));

        // Update doctor details
        existingDoctor.setUsername(doctorDTO.getUsername());
        existingDoctor.setSpecialization(doctorDTO.getSpecialty());

        // Optionally update role if a new role ID is provided
        if (doctorDTO.getRoleId() != null) {
            Role role = roleRepository.findById(doctorDTO.getRoleId())
                    .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + doctorDTO.getRoleId()));
            existingDoctor.setRole(role);
        }

        Doctor updatedDoctor = doctorRepository.save(existingDoctor);
        return mapToDTO(updatedDoctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
        doctorRepository.delete(doctor);
    }

    private DoctorDTO mapToDTO(Doctor doctor) {
        return modelMapper.map(doctor, DoctorDTO.class);
    }

    private Doctor mapToEntity(DoctorDTO doctorDTO) {
        return modelMapper.map(doctorDTO, Doctor.class);
    }
}
