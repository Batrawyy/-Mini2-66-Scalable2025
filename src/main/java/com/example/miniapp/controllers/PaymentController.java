package com.example.miniapp.controllers;

import com.example.miniapp.models.Payment;
import com.example.miniapp.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;
    
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    
    // Add a new payment
    @PostMapping("/addPayment")
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentService.addPayment(payment);
    }
    
    // Get all payments
    @GetMapping("/allPayments")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }
    
    // Get payment by ID
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }
    
    // Update payment
    @PutMapping("/update/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        return paymentService.updatePayment(id, payment);
    }
    
    // Delete payment
    @DeleteMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "Payment with ID: " + id + " has been deleted successfully";
    }
    
    // Find payments by trip ID
    @GetMapping("/findByTripId")
    public List<Payment> findPaymentsByTripId(@RequestParam Long tripId) {
        return paymentService.findPaymentsByTripId(tripId);
    }
    
    // Find payments with an amount greater than a threshold
    @GetMapping("/findByAmountThreshold")
    public List<Payment> findPaymentsWithAmountGreaterThan(@RequestParam Double threshold) {
        return paymentService.findByAmountThreshold(threshold);
    }
}