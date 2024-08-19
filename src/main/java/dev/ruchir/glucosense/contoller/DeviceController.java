package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.dto.Support_dto.DeviceDTO;
import dev.ruchir.glucosense.service.Interface.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDTO> getDeviceById(@PathVariable Long id) {
        DeviceDTO device = deviceService.getDeviceById(id);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DeviceDTO> createDevice(@RequestBody DeviceDTO deviceDTO) {
        DeviceDTO createdDevice = deviceService.createDevice(deviceDTO);
        return new ResponseEntity<>(createdDevice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceDTO> updateDevice(@PathVariable Long id, @RequestBody DeviceDTO deviceDTO) {
        DeviceDTO updatedDevice = deviceService.updateDevice(id, deviceDTO);
        return new ResponseEntity<>(updatedDevice, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/patients/{patientId}")
    public ResponseEntity<List<DeviceDTO>> getDevicesByPatientId(@PathVariable Long patientId) {
        List<DeviceDTO> devices = deviceService.getDevicesByPatientId(patientId);
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }
}
