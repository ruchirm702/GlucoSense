package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.InvalidPaymentDataException;
import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.PaymentNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.PaymentDTO;
import dev.ruchir.glucosense.model.Core.Payment;
import dev.ruchir.glucosense.model.Core.Billing;
import dev.ruchir.glucosense.repository.PaymentRepository;
import dev.ruchir.glucosense.repository.BillingRepository;
import dev.ruchir.glucosense.service.Interface.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final BillingRepository billingRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, BillingRepository billingRepository) {
        this.paymentRepository = paymentRepository;
        this.billingRepository = billingRepository;
    }

    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        Billing billing = billingRepository.findById(paymentDTO.getBillingId())
                .orElseThrow(() -> new InvalidPaymentDataException("Billing not found"));

        Payment payment = new Payment();
        payment.setBilling(billing);
        payment.setAmountPaid(paymentDTO.getAmountPaid());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setPaymentStatus(paymentDTO.getPaymentStatus());
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());

        payment = paymentRepository.save(payment);
        return mapToDTO(payment);
    }

    @Override
    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment record not found"));
        return mapToDTO(payment);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public PaymentDTO updatePayment(Long id, PaymentDTO paymentDTO) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment record not found"));

        payment.setAmountPaid(paymentDTO.getAmountPaid());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setPaymentStatus(paymentDTO.getPaymentStatus());
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());

        payment = paymentRepository.save(payment);
        return mapToDTO(payment);
    }

    @Override
    public void deletePayment(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment record not found"));
        paymentRepository.delete(payment);
    }

    private PaymentDTO mapToDTO(Payment payment) {
        return new PaymentDTO(
                payment.getId(),
                payment.getBilling().getId(),
                payment.getAmountPaid(),
                payment.getPaymentDate(),
                payment.getPaymentStatus(),
                payment.getPaymentMethod()
        );
    }
}
