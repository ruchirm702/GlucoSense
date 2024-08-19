package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.ResourceNotFoundException;
import dev.ruchir.glucosense.dto.Enum_dto.DeviceTypeDTO;
import dev.ruchir.glucosense.dto.Support_dto.DeviceDTO;
import dev.ruchir.glucosense.model.Enum.DeviceType;
import dev.ruchir.glucosense.model.support.Device;
import dev.ruchir.glucosense.repository.DeviceRepository;
import dev.ruchir.glucosense.service.Interface.DeviceService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceServiceIMPL implements DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceServiceIMPL(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public DeviceDTO getDeviceById(Long id) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found"));
        return mapToDTO(device);
    }

    @Override
    public DeviceDTO createDevice(DeviceDTO deviceDTO) {
        Device device = mapToEntity(deviceDTO);
        device = deviceRepository.save(device);
        return mapToDTO(device);
    }

    @Override
    public DeviceDTO updateDevice(Long id, DeviceDTO deviceDTO) {
        Device existingDevice = deviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found"));
        existingDevice.setDeviceName(deviceDTO.getName());
        existingDevice.setDeviceId(deviceDTO.getSerialNumber());
        existingDevice.setDeviceType(DeviceType.valueOf(deviceDTO.getType().getTypeName()));
        existingDevice = deviceRepository.save(existingDevice);
        return mapToDTO(existingDevice);
    }

    @Override
    public void deleteDevice(Long id) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found"));
        deviceRepository.delete(device);
    }

    @Override
    public List<DeviceDTO> getDevicesByPatientId(Long patientId) {
        List<Device> devices = deviceRepository.findByPatientId(patientId);
        return devices.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private DeviceDTO mapToDTO(Device device) {
        DeviceDTO dto = new DeviceDTO();
        dto.setId(device.getId());
        dto.setName(device.getDeviceName());
        dto.setSerialNumber(device.getDeviceId());
        dto.setType(new DeviceTypeDTO(device.getDeviceType().name()));
        // Map patient if needed
        return dto;
    }

    private Device mapToEntity(DeviceDTO dto) {
        Device device = new Device();
        device.setDeviceName(dto.getName());
        device.setDeviceId(dto.getSerialNumber());
        device.setDeviceType(DeviceType.valueOf(dto.getType().getTypeName()));
        // Map patient if needed
        return device;
    }
}
