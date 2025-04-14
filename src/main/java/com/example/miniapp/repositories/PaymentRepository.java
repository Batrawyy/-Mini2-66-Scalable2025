package com.example.miniapp.repositories;

import com.example.miniapp.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Payments by trip ID
    List<Payment> findByTripId(Long tripId);

    // Payments above amount threshold
    List<Payment> findByAmountGreaterThan(Double threshold);
}
