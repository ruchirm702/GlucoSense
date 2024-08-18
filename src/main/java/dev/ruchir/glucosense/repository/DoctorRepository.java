package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("SELECT DISTINCT c.doctor FROM Consultation c WHERE c.patient.id = :patientId")
    List<Doctor> findDoctorsByPatientId(@Param("patientId") Long patientId);
}
