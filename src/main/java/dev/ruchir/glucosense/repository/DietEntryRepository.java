package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.DietEntry;
import dev.ruchir.glucosense.model.Enum.DietType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietEntryRepository extends JpaRepository<DietEntry, Long> {
    List<DietEntry> findByPatientId(Long patientId);
    List<DietEntry> findByDietType(DietType dietType);
}
