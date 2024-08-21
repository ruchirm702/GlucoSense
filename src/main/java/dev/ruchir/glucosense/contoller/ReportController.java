package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.dto.Core_Dto.ReportDTO;
import dev.ruchir.glucosense.model.Enum.ReportType;
import dev.ruchir.glucosense.service.Interface.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // Endpoint to generate a new report for a patient
    @PostMapping("/generate")
    public ResponseEntity<ReportDTO> generateReport(
            @RequestParam Long patientId,
            @RequestParam ReportType reportType) {

        try {
            ReportDTO reportDTO = reportService.generateReport(patientId, reportType);
            return new ResponseEntity<>(reportDTO, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to get a report by its ID
    @GetMapping("/{reportId}")
    public ResponseEntity<ReportDTO> getReportById(@PathVariable Long reportId) {
        try {
            ReportDTO reportDTO = reportService.getReportById(reportId);
            return new ResponseEntity<>(reportDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to get all reports for a patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ReportDTO>> getReportsByPatientId(@PathVariable Long patientId) {
        try {
            List<ReportDTO> reportDTOs = reportService.getReportsByPatientId(patientId);
            return new ResponseEntity<>(reportDTOs, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
