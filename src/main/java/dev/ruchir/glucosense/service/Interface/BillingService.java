package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.dto.Core_Dto.BillingDTO;

import java.util.List;

public interface BillingService {
    BillingDTO createBilling(BillingDTO billingDTO);
    BillingDTO getBillingById(Long id);
    List<BillingDTO> getAllBillings();
    BillingDTO updateBilling(Long id, BillingDTO billingDTO);
    void deleteBilling(Long id);
}
