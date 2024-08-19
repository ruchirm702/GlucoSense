package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.dto.Support_dto.DeviceDTO;
import java.util.List;

public interface DeviceService {
    DeviceDTO getDeviceById(Long id);
    DeviceDTO createDevice(DeviceDTO deviceDTO);
    DeviceDTO updateDevice(Long id, DeviceDTO deviceDTO);
    void deleteDevice(Long id);
    List<DeviceDTO> getDevicesByPatientId(Long patientId);
}
