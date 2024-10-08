package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.Patient;
import dev.ruchir.glucosense.model.Enum.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Count patients by blood type
    @Query("SELECT COUNT(p) FROM Patient p WHERE p.bloodType = :bloodType")
    Long countByBloodType(@Param("bloodType") BloodType bloodType);

    // Find patients by username (for searching by name)
    @Query("SELECT p FROM Patient p WHERE p.firstName LIKE %:name% OR p.lastName LIKE %:name%")
    List<Patient> findByName(@Param("name") String name);
}
