package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.AppointmentConflictException;
import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.AppointmentNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.AppointmentDTO;
import dev.ruchir.glucosense.service.Interface.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        try {
            AppointmentDTO createdAppointment = appointmentService.createAppointment(appointmentDTO);
            return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
        } catch (AppointmentConflictException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(
            @PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) {
        try {
            AppointmentDTO updatedAppointment = appointmentService.updateAppointment(id, appointmentDTO);
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
        } catch (AppointmentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (AppointmentConflictException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        try {
            appointmentService.deleteAppointment(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (AppointmentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id) {
        Optional<AppointmentDTO> appointmentDTO = appointmentService.getAppointmentById(id);
        return appointmentDTO
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        List<AppointmentDTO> appointments = appointmentService.getAllAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
}
