package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.dto.Core_Dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    DoctorDTO getDoctorById(Long id);

    List<DoctorDTO> getAllDoctors();

    DoctorDTO createDoctor(DoctorDTO doctorDTO);

    DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO);

    void deleteDoctor(Long id);
}
