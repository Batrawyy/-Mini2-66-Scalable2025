
package com.example.miniapp.services;

import com.example.miniapp.models.Payment;
import com.example.miniapp.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    
    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    
    // Add a new payment
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    
    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    
    // Get payment by ID
    public Payment getPaymentById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.orElse(null);
    }
    
    // Update payment
    public Payment updatePayment(Long id, Payment payment) {
        if (paymentRepository.existsById(id)) {
            payment.setId(id);
            return paymentRepository.save(payment);
        }
        return null;
    }
    
    // Delete payment
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
    
    // Find payments by trip ID
    public List<Payment> findPaymentsByTripId(Long tripId) {
        return paymentRepository.findByTripId(tripId);
    }
    
    // Find payments with an amount greater than a threshold
    public List<Payment> findByAmountThreshold(Double threshold) {
        return paymentRepository.findByAmountGreaterThan(threshold);
    }
}