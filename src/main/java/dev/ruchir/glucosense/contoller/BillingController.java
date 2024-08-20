package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.BillingNotFoundException;
import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.InvalidBillingDataException;
import dev.ruchir.glucosense.dto.Core_Dto.BillingDTO;
import dev.ruchir.glucosense.service.Interface.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billings")
public class BillingController {

    private final BillingService billingService;

    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping
    public ResponseEntity<BillingDTO> createBilling(@RequestBody BillingDTO billingDTO) {
        try {
            BillingDTO createdBilling = billingService.createBilling(billingDTO);
            return new ResponseEntity<>(createdBilling, HttpStatus.CREATED);
        } catch (InvalidBillingDataException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillingDTO> getBillingById(@PathVariable Long id) {
        try {
            BillingDTO billingDTO = billingService.getBillingById(id);
            return new ResponseEntity<>(billingDTO, HttpStatus.OK);
        } catch (BillingNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<BillingDTO>> getAllBillings() {
        List<BillingDTO> billings = billingService.getAllBillings();
        return new ResponseEntity<>(billings, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillingDTO> updateBilling(@PathVariable Long id, @RequestBody BillingDTO billingDTO) {
        try {
            BillingDTO updatedBilling = billingService.updateBilling(id, billingDTO);
            return new ResponseEntity<>(updatedBilling, HttpStatus.OK);
        } catch (BillingNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (InvalidBillingDataException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilling(@PathVariable Long id) {
        try {
            billingService.deleteBilling(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (BillingNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
