package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.dto.Core_Dto.ReportDTO;
import dev.ruchir.glucosense.dto.Enum_dto.ReportStatusDTO;
import dev.ruchir.glucosense.dto.Enum_dto.ReportTypeDTO;
import dev.ruchir.glucosense.model.Core.Report;
import dev.ruchir.glucosense.model.Core.Patient;
import dev.ruchir.glucosense.model.Enum.ReportType;
import dev.ruchir.glucosense.model.Enum.ReportStatus;
import dev.ruchir.glucosense.repository.PatientRepository;
import dev.ruchir.glucosense.repository.ReportRepository;
import dev.ruchir.glucosense.service.Interface.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceIMPL implements ReportService {

    private final ReportRepository reportRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public ReportServiceIMPL(ReportRepository reportRepository, PatientRepository patientRepository) {
        this.reportRepository = reportRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public ReportDTO generateReport(Long patientId, ReportType reportType) {
        // Fetch patient information
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Generate report content based on type (this is a simplified example)
        String reportContent = "Generated report content based on " + reportType;

        Report report = new Report();
        report.setReportType(reportType);
        report.setReportStatus(ReportStatus.PENDING);
        report.setPatient(patient);
        report.setReportContent(reportContent);
        report.setGeneratedDate(LocalDateTime.now());

        Report savedReport = reportRepository.save(report);
        return convertToDTO(savedReport);
    }

    @Override
    public ReportDTO getReportById(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Report not found"));
        return convertToDTO(report);
    }

    @Override
    public List<ReportDTO> getReportsByPatientId(Long patientId) {
        List<Report> reports = reportRepository.findByPatientId(patientId);
        return reports.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ReportDTO convertToDTO(Report report) {
        ReportDTO dto = new ReportDTO();
        dto.setId(report.getId());
        dto.setReportType(ReportTypeDTO.valueOf(report.getReportType().name()));
        dto.setReportStatus(ReportStatusDTO.valueOf(report.getReportStatus().name()));
        dto.setPatientId(report.getPatient().getId());
        dto.setReportContent(report.getReportContent());
        dto.setGeneratedDate(report.getGeneratedDate());
        return dto;
    }
}
