package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.Report;
import dev.ruchir.glucosense.model.Enum.ReportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByPatientId(Long patientId);
    List<Report> findByReportType(ReportType reportType);
}
