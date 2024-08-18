package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.Consultation;
import dev.ruchir.glucosense.model.Core.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    List<Consultation> findByPatientId(Long patientId);
    List<Consultation> findByDoctorId(Long doctorId);

    List<Doctor> findDoctorsByPatientId(Long patientId);
}
