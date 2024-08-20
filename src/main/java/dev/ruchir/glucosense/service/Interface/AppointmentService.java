package dev.ruchir.glucosense.service.Interface;



import dev.ruchir.glucosense.dto.Core_Dto.AppointmentDTO;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);

    AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO);

    void deleteAppointment(Long id);

    Optional<AppointmentDTO> getAppointmentById(Long id);

    List<AppointmentDTO> getAllAppointments();
}
