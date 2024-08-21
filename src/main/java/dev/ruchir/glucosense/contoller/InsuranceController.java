package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.InsuranceNotFoundException;
import dev.ruchir.glucosense.model.Core.Insurance;
import dev.ruchir.glucosense.service.Interface.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {

    private final InsuranceService insuranceService;

    @Autowired
    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping
    public ResponseEntity<Insurance> createInsurance(@RequestBody Insurance insurance) {
        Insurance createdInsurance = insuranceService.createInsurance(insurance);
        return new ResponseEntity<>(createdInsurance, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Insurance> updateInsurance(@PathVariable Long id, @RequestBody Insurance insurance) {
        try {
            Insurance updatedInsurance = insuranceService.updateInsurance(id, insurance);
            return new ResponseEntity<>(updatedInsurance, HttpStatus.OK);
        } catch (InsuranceNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Insurance> getInsuranceById(@PathVariable Long id) {
        try {
            Insurance insurance = insuranceService.getInsuranceById(id);
            return new ResponseEntity<>(insurance, HttpStatus.OK);
        } catch (InsuranceNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsurance(@PathVariable Long id) {
        try {
            insuranceService.deleteInsurance(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (InsuranceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Insurance>> getAllInsurance() {
        List<Insurance> insuranceList = insuranceService.getAllInsurance();
        return new ResponseEntity<>(insuranceList, HttpStatus.OK);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Insurance>> getInsuranceByPatientId(@PathVariable Long patientId) {
        List<Insurance> insuranceList = insuranceService.getInsuranceByPatientId(patientId);
        return new ResponseEntity<>(insuranceList, HttpStatus.OK);
    }

    @GetMapping("/policy/{policyNumber}")
    public ResponseEntity<Insurance> getInsuranceByPolicyNumber(@PathVariable String policyNumber) {
        Insurance insurance = insuranceService.getInsuranceByPolicyNumber(policyNumber);
        return insurance != null ? new ResponseEntity<>(insurance, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/provider/{providerName}")
    public ResponseEntity<List<Insurance>> getInsuranceByProviderName(@PathVariable String providerName) {
        List<Insurance> insuranceList = insuranceService.getInsuranceByProviderName(providerName);
        return new ResponseEntity<>(insuranceList, HttpStatus.OK);
    }

    @GetMapping("/expiry/before/{date}")
    public ResponseEntity<List<Insurance>> getInsuranceByExpiryDateBefore(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<Insurance> insuranceList = insuranceService.getInsuranceByExpiryDateBefore(localDate);
        return new ResponseEntity<>(insuranceList, HttpStatus.OK);
    }

    @GetMapping("/expiry/after/{date}")
    public ResponseEntity<List<Insurance>> getInsuranceByExpiryDateAfter(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<Insurance> insuranceList = insuranceService.getInsuranceByExpiryDateAfter(localDate);
        return new ResponseEntity<>(insuranceList, HttpStatus.OK);
    }

    @GetMapping("/provider/count/{providerName}")
    public ResponseEntity<Long> countInsuranceByProviderName(@PathVariable String providerName) {
        long count = insuranceService.countInsuranceByProviderName(providerName);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
