package dev.ruchir.glucosense.repository;


import dev.ruchir.glucosense.model.support.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Custom query to find roles by patient ID
    @Query("SELECT r FROM Role r JOIN r.patients p WHERE p.id = :patientId")
    List<Role> findByPatientId(@Param("patientId") Long patientId);
}
