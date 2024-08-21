package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.dto.Core_Dto.ReportDTO;
import dev.ruchir.glucosense.model.Enum.ReportType;

import java.util.List;

public interface ReportService {
    ReportDTO generateReport(Long patientId, ReportType reportType);
    ReportDTO getReportById(Long reportId);
    List<ReportDTO> getReportsByPatientId(Long patientId);
}
