package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findBySpecialty(String specialty);
}
