package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.support.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Optional<Device> findByDeviceId(String deviceId); // Updated field name
    List<Device> findByPatientId(Long patientId); // This remains unchanged
}
